
package softpro.Persistence;

import java.util.HashMap;
import java.util.List;
import softpro.Model.ProductBacklog;
import softpro.Model.ScrumProject;
import softpro.Model.State;
import softpro.Model.UserStory;

public class ProductBacklogLoader {
    
    public ProductBacklog loadBacklogOf(ScrumProject project){
        ProductBacklog backlog = new ProductBacklog();
        backlog.create(0, "", "", 0, 0, State.ToDo).create(0, "", "", State.ToDo, null, 0, 0);
        return backlog;
    }

    private void loadTasksOf(UserStory userStory){
        
        
    }
    
}
