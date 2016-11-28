package softpro.Model;

import java.util.List;

public class UseCase {
    private String description;
    private String details;
    private final int id;
    private int points;
    private final List<Task> taskList;

    public UseCase(String description, String details, int id, int points, List<Task> taskList) {
        this.description = description;
        this.details = details;
        this.id = id;
        this.points = points;
        this.taskList = taskList;
    }

    public String getDescription() {
        return description;
    }

    public String getDetails() {
        return details;
    }

    public int getId() {
        return id;
    }

    public int getPoints() {
        return points;
    }

    public void setName(String name) {
        this.description = name;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    
    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public int hashCode() {
        return 67 * 3 + this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        return this.id == ((UseCase) obj).id;
    }
}