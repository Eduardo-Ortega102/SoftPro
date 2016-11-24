package softpro.Persistence;

import java.util.List;

public interface ObjectManager<E> {

    List<E> loadAll();

    List<E> loadRelatedWith(int id);

    E load(int id);

    boolean exist(int id);
    
    boolean insert(E record);
    
    boolean update(E record);

    boolean delete(E record);
    
}
