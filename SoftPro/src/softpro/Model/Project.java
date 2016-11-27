package softpro.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import softpro.Model.Factories.RiskFactory;
import softpro.Model.Factories.UseCaseFactory;
import softpro.Persistence.Database.SqliteInterface;

public abstract class Project implements UseCaseFactory, RiskFactory {

    protected String name;
    protected final int id;
    protected List<UseCase> useCaseList;
    protected List<Risk> riskList;

    public Project(int id, String name) {
        this.id = id;
        this.name = name;
        this.useCaseList = new ArrayList<>();
        this.riskList = new ArrayList<>();
    }
    
    public abstract String getType();

    public List<UseCase> cases() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Risk> risks() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public UseCase create() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    //TODO - Check ID
    public void saveProject() {
        SqliteInterface sqliteInterface = new SqliteInterface();
        Map<String, Object> mapaValores = new HashMap<>();

        mapaValores.put("id", this.id);
        mapaValores.put("nombre", this.name);
        mapaValores.put("tipo", this.getType());
        sqliteInterface.insertInto("project", mapaValores);
    }

}
