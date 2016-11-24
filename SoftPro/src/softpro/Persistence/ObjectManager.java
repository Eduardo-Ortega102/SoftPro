package softpro.Persistence;

import java.util.List;

public interface ObjectManager<E,R> {

    List<E> loadAll();

    List<E> loadRelatedWith(R record);

    E load(int id);

    boolean exist(int id);
    
    boolean insert(E element);
    
    boolean update(E element);

    boolean delete(E element);
    
}
