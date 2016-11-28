package softpro.Model.Incremental;

public class UseCase {
    private String description;
    private String details;
    private final int id;

    public UseCase(String description, String details, int id) {
        this.description = description;
        this.details = details;
        this.id = id;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDetails(String details) {
        this.details = details;
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