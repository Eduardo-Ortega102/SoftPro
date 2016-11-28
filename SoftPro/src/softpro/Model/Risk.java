
package softpro.Model;

public class Risk {
    private final int id;
    private String description;
    private String contingency_plan;

    public Risk(int id, String description, String contingency_plan) {
        this.id = id;
        this.description = description;
        this.contingency_plan = contingency_plan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContingency_plan() {
        return contingency_plan;
    }

    public void setContingency_plan(String contingency_plan) {
        this.contingency_plan = contingency_plan;
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return 37 * 7 + this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        return this.id == ((Risk) obj).id;
    }
    
    
            
}
