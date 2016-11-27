package softpro.Model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sprint implements Iterable<Task> {

    private final int id;
    private Instant fecha_inicio;
    private Instant fecha_fin;
    private final List<Task> taskList;

    public Sprint(int id, Instant fecha_inicio, Instant fecha_fin) {
        this.id = id;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.taskList = new ArrayList<>();
    }

    public Instant getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Instant fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Instant getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Instant fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    @Override
    public int hashCode() {
        return 53 * 7 + this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        return this.id == ((Sprint) obj).id;
    }
    
    public void addTask(Task task) {
        this.taskList.add(task);
    }

    public void removeTask(Task task) {
        this.taskList.remove(task);
    }
    
    @Override
    public Iterator<Task> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
