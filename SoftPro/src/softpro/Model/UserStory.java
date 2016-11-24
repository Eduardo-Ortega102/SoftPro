package softpro.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserStory implements Iterable<Task>{
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

    
    
    public void addTask(Task task) {
        this.taskList.add(task);
    }

    public void removeTask(Task task) {
        this.taskList.remove(task);
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
}
