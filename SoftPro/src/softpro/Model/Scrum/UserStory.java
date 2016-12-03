package softpro.Model.Scrum;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import softpro.Model.State;
import softpro.Model.User;

public class UserStory implements Iterable<UserStory> {
    private String description;
    private String details;
    private State state;
    private final int id;
    private int points;
    private int priority;
    private User responsible;
    private final List<UserStory> predecessors;
                     
    public UserStory(int id, String description, String details, int points, int priority, State state, User responsible) {
        this.description = description;
        this.details = details;
        this.state = state;
        this.id = id;
        this.points = points;
        this.priority = priority;
        this.responsible = responsible;
        this.predecessors = new ArrayList<>();
    }

    public String getDescription() {
        return description;
    }

    public String getDetails() {
        return details;
    }

    public State getState() {
        return state;
    }

    public int getId() {
        return id;
    }

    public int getPoints() {
        return points;
    }

    public int getPriority() {
        return priority;
    }

    public User getResponsible() {
        return responsible;
    }

    public void setResponsible(User responsible) {
        this.responsible = responsible;
    }

    public void setName(String name) {
        this.description = name;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int hashCode() {
        return 67 * 3 + this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        return this.id == ((UserStory) obj).id;
    }

    @Override
    public Iterator<UserStory> iterator() {
        return this.predecessors.iterator();
    }

    public boolean addPredecessor(UserStory story){
        return predecessors.add(story);
    }
    
    public boolean removePredecessor(UserStory story){
        return predecessors.remove(story);
    }

    public UserStory findPredecessor(int id) {
        for (UserStory predecessor : predecessors)
            if (predecessor.getId() == id) return predecessor;
        return null;
    }
}
