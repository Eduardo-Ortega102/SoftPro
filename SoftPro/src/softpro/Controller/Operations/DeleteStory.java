/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softpro.Controller.Operations;

import static java.lang.Integer.valueOf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import softpro.Model.Scrum.ScrumProject;
import softpro.Model.Scrum.Sprint;
import softpro.Model.Scrum.UserStory;
import softpro.Persistence.Database.SqliteInterface;
import softpro.View.ActionOverProject;

/**
 *
 * @author Mictlan
 */
public class DeleteStory implements ActionOverProject<ScrumProject> {

    @Override
    public boolean execute(ScrumProject project, HashMap<String, String> arguments) {
        UserStory story = project.getBacklog().findStory(valueOf(arguments.get("storyID")));
        if(story == null) return false;
        List<UserStory> predecessors = new ArrayList<>();
        List<UserStory> successors = new ArrayList<>();
        for (UserStory userStory : project.getBacklog()) {
            if(userStory.findPredecessor(story.getId()) != null){
                successors.add(userStory);
            }
        }
        for (UserStory userStory : story) predecessors.add(userStory);
        
        if(!successors.isEmpty()){
            for (UserStory successor : successors) {
                for (UserStory predecessor : predecessors) {
                    databaseModifyPredecessor(story, successor, predecessor);
                    successor.removePredecessor(story);
                    successor.addPredecessor(predecessor);
                }
            }
        }
        if(databaseDeleteStoryError(story)==false) return false;
        if(databaseDeleteStoryFromSprintError(story)==false) return false;
        for (Sprint sprint : project) {
            sprint.removeUserStory(story);
        }
        return project.getBacklog().delete(story);
    }
    
    private boolean databaseDeleteStoryError(UserStory story){
        String id = "id="+story.getId();
        return new SqliteInterface().deleteFrom("features",id);
    }
    
    private boolean databaseDeleteStoryFromSprintError(UserStory story){
        String id = "story="+story.getId();
        return new SqliteInterface().deleteFrom("sprint_backlog",id);
    }
    
    private boolean databaseModifyPredecessor(UserStory story, UserStory successor, UserStory predecessor){
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("story", successor.getId());
        mapa.put("predecessor", predecessor.getId());
        String where = "story = " + story.getId();
        return new SqliteInterface().update("story_predecessors", mapa,where);
    }
}
