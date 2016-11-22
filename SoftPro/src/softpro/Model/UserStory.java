package softpro.Model;

import java.util.ArrayList;
import java.util.List;

public class UserStory {

    private String name;
    private String description;
    private State state;
    private int points;
    private int priority;
    private List<Task> taskList;

    public UserStory(String name, String description, int points, int prioridad, State state) {
        this.name = name;
        this.description = description;
        this.state = state;
        this.points = points;
        this.priority = prioridad;
        this.taskList = new ArrayList<>();
    }

    public UserStory(String name, String description, int points, int prioridad) {
        this(name, description, points, prioridad, State.ToDo);
    }

    public UserStory(String name, String description) {
        this(name, description, 0, 0, State.ToDo);
    }

    public String getDescription() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public String getDetalles() {
        return description;
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
    
    public void addTask(){
        this.taskList.add(new Task());
    }
    
    public void removeTask(){
        
    }
}
