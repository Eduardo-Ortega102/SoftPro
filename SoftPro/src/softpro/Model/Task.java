package softpro.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import softpro.Model.Factories.TaskFactory;

public class Task implements Iterable<Task>, TaskFactory{

    private final int id;
    private State state;
    private User responsible;
    private String description;
    private String details;
    private int estimated_duration;
    private int real_duration;
    private List<Task> predecesors;

    public Task(int id, State state, User responsible, String description, String details, int estimated_duration, int real_duration) {
        this.id = id;
        this.state = state;
        this.responsible = responsible;
        this.description = description;
        this.details = details;
        this.estimated_duration = estimated_duration;
        this.real_duration = real_duration;
        this.predecesors = new ArrayList<>();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setResponsible(User responsible) {
        this.responsible = responsible;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setEstimated_duration(int estimated_duration) {
        this.estimated_duration = estimated_duration;
    }

    public void setReal_duration(int real_duration) {
        this.real_duration = real_duration;
    }

    public int getId() {
        return id;
    }

    public State getState() {
        return state;
    }

    public User getResponsible() {
        return responsible;
    }

    public String getDescription() {
        return description;
    }

    public String getDetails() {
        return details;
    }

    public int getEstimated_duration() {
        return estimated_duration;
    }

    public int getReal_duration() {
        return real_duration;
    }
    
    public void addPredecesor(Task task){
        this.predecesors.add(task);
    }
    
    public void removePredecesor(Task task){
        this.predecesors.remove(task);
    }

    @Override
    public int hashCode() {
        return 61 * 7 + this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        return this.id == ((Task) obj).id;
    }

    @Override
    public Iterator<Task> iterator() {
        return this.predecesors.iterator();
    }

    @Override
    public boolean delete(Task task) {
        return this.predecesors.remove(task);
    }

    @Override
    public Task create(int id, String description) {
        return create(id, description, "");
    }

    @Override
    public Task create(int id, String description, String details) {
        return create(id, description, details, State.ToDo);
    }

    @Override
    public Task create(int id, String description, String details, State state) {
        return create(id, description, details, state, null);
    }

    @Override
    public Task create(int id, String description, String details, State state, User responsible) {
        return create(id, description, details, state, responsible, 0);
    }

    @Override
    public Task create(int id, String description, String details, State state, User responsible, int estimated_duration) {
        return create(id, description, details, state, responsible, estimated_duration, 0);
    }

    @Override
    public Task create(int id, String description, String details, State state, User responsible, int estimated_duration, int real_duration) {
        Task task = new Task(id, state, responsible, description, details, estimated_duration, real_duration);
        predecesors.add(task);
        return task;
    }
}
