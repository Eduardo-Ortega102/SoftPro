package softpro.Model;

import java.util.ArrayList;
import java.util.List;
import softpro.Model.Factories.RiskFactory;
import softpro.Model.Factories.UseCaseFactory;

public abstract class Project implements UseCaseFactory, RiskFactory {

    protected final int id;
    protected String name;
    protected Team team;
    protected List<UseCase> useCaseList;
    protected List<Risk> riskList;

    public Project(int id, String name) {
        this.id = id;
        this.name = name;
        this.useCaseList = new ArrayList<>();
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

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<UseCase> cases() {
        return this.useCaseList;
    }

    public List<Risk> risks() {
        return this.riskList;
    }

    @Override
    public boolean delete(UseCase useCase) {
        return this.useCaseList.remove(useCase);
    }

    @Override
    public UseCase create(int id, String description) {
        return create(id, description, "");
    }

    @Override
    public UseCase create(int id, String description, String details) {
        UseCase useCase = new UseCase(description, details, id);
        this.useCaseList.add(useCase);
        return useCase;
    }


}
