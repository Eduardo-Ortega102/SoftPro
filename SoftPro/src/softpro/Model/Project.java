package softpro.Model;

import java.util.ArrayList;
import java.util.List;
import softpro.Model.Factories.RiskFactory;

public abstract class Project implements RiskFactory {

    protected final int id;
    protected String name;
    protected Team team;
    protected List<Risk> riskList;

    public Project(int id, String name) {
        this.id = id;
        this.name = name;
        this.team = new Team();
        this.riskList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract String getType();

    public Team getTeam() {
        return team;
    }

    public List<Risk> risks() {
        return this.riskList;
    }

}
