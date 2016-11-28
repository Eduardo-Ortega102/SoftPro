
package softpro.Model;

public class Risk {
    private int id;
    private String description;
    private String project;
    private String contingency_plan;
    
    public Risk(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
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
            
}
