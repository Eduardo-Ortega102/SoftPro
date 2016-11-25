package softpro.Model;

public abstract class Project {
    protected String name;
    //protected static int id = read from table project last id;

    public Project(String name) {
        this.name = name;
        //Project.id = id++;
    }

}
