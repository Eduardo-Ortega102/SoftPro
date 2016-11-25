package softpro.Model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import softpro.Model.Factories.SprintFactory;

public class ScrumProject extends Project implements Iterable<Sprint>, SprintFactory {

    private final ProductBacklog backlog;
    private final List<Sprint> sprintList;

    public ScrumProject(int id, String name) {
        super(id, name);
        this.backlog = new ProductBacklog();
        this.sprintList = new ArrayList<>();
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
    public Sprint create(int id, Instant fecha_inicio) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Sprint create(int id, Instant fecha_inicio, Instant fecha_fin) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(Sprint sprint) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
