package softpro.Model.Factories;

import java.time.LocalDate;
import softpro.Model.Scrum.Sprint;

public interface SprintFactory {

    Sprint create(int id, LocalDate fecha_inicio);

    Sprint create(int id, LocalDate fecha_inicio, LocalDate fecha_fin);
    
    boolean delete(Sprint sprint);
}
