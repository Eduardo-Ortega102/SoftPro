package softpro.Model.Scrum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import softpro.Model.Factories.SprintFactory;
import softpro.Model.Project;
import softpro.Model.User;

public class ScrumProject extends Project implements Iterable<Sprint>, SprintFactory {

    private final ProductBacklog backlog;
    private final List<Sprint> sprintList;

    public ScrumProject(int id, String name, ProductBacklog backlog) {
        super(id, name);
        this.backlog = backlog != null ? backlog : new ProductBacklog();
        this.sprintList = new ArrayList<>();
    }

    public ScrumProject(int id, String name) {
        this(id, name, null);
    }

    
    @Override
    public String getType() {
        return "Scrum";
    }

    public ProductBacklog getBacklog() {
        return backlog;
    }

    @Override
    public Iterator<Sprint> iterator() {
        return this.sprintList.iterator();
    }

    @Override
    public void addUser(User user) {
        team.addUser(user);
        for (Sprint sprint : this) sprint.incrementTeamSize();
    }

    @Override
    public void removeUser(User user) {
        team.removeUser(user);
        for (Sprint sprint : this) sprint.decrementTeamSize();
    }

    @Override
    public Sprint create(int id, LocalDate fecha_inicio, int weeks) {
        Sprint sprint = new Sprint(id, fecha_inicio, weeks, team.getamountOfMembers());
        this.sprintList.add(sprint);
        return sprint;
    }

    @Override
    public boolean delete(Sprint sprint) {
        return this.sprintList.remove(sprint);
    }
    
    public Sprint findSprint(int id){
        for (Sprint sprint : sprintList) 
            if (sprint.getId() == id) return sprint;
        return null;
    }


}
