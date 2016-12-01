package softpro.View;

import java.util.HashMap;

@FunctionalInterface
public interface Action<E> {

    boolean execute(E project, HashMap<String, String> arguments);

}
