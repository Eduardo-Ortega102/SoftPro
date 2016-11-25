package softpro.Model.Factories;

import java.time.Instant;
import softpro.Model.Sprint;

public interface SprintFactory {

    Sprint create(int id, Instant fecha_inicio);

    Sprint create(int id, Instant fecha_inicio, Instant fecha_fin);
    
    boolean delete(Sprint sprint);
}
