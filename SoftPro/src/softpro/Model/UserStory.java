package softpro.Model;

import java.util.ArrayList;
import java.util.List;

public class UserStory {

    private String name;
    private String details;
    private State state;
    private int id;
    private int points;
    private int priority;
    private List<Task> taskList;

    public UserStory(String name, String details, int points, int id, int prioridad) {
        this(name, details, points, id, prioridad, State.ToDo);
    }

    public UserStory(String name, String details) {
        this(name, details, 0, 0, 0, State.ToDo);
    }

    public UserStory(String name, String details, int points, int id, int prioridad, State state) {
        this.name = name;
        this.details = details;
        this.state = state;
        this.id = id;
        this.points = points;
        this.priority = prioridad;
        this.taskList = new ArrayList<>();
    }

    public String getDescription() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public String getDetalles() {
        return details;
    }

    public State getState() {
        return state;
    }

    public int getPrioridad() {
        return priority;
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

    public void addTask(String description) {
        this.taskList.add(new Task());
    }

    public void removeTask(int id) {

    }
}
