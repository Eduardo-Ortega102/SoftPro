package softpro.Model.Scrum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import softpro.Model.Factories.SprintFactory;
import softpro.Model.Project;

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
    public Sprint create(int id, LocalDate fecha_inicio) {
        return create(id, fecha_inicio, null);
    }

    @Override
    public Sprint create(int id, LocalDate fecha_inicio, LocalDate fecha_fin) {
        Sprint sprint = new Sprint(id, fecha_inicio, fecha_fin);
        this.sprintList.add(sprint);
        return sprint;
    }

    @Override
    public boolean delete(Sprint sprint) {
        return this.sprintList.remove(sprint);
    }

}
