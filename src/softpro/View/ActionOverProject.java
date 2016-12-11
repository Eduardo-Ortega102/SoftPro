package softpro.View;

import java.util.HashMap;

@FunctionalInterface
public interface ActionOverProject<E> {

    boolean execute(E project, HashMap<String, String> arguments);

}
