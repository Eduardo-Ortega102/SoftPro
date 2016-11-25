package softpro.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import softpro.Model.Factories.TaskFactory;

public class UserStory implements Iterable<Task>, TaskFactory {
    private String description;
    private String details;
    private State state;
    private final int id;
    private int points;
    private int priority;
    private List<Task> taskList;

    public UserStory(String description, String details, int points, int id, int prioridad, State state) {
        this.description = description;
        this.details = details;
        this.state = state;
        this.id = id;
        this.points = points;
        this.priority = prioridad;
        this.taskList = new ArrayList<>();
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
    public Iterator<Task> iterator() {
        return this.taskList.iterator();
    }

    @Override
    public boolean delete(Task task) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Task create(int id, String description) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Task create(int id, String description, String details) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Task create(int id, String description, String details, State state) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Task create(int id, String description, String details, State state, User responsible) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Task create(int id, String description, String details, State state, User responsible, int estimated_duration) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Task create(int id, String description, String details, State state, User responsible, int estimated_duration, int real_duration) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
