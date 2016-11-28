package softpro.Model.Scrum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import softpro.Model.Task;

public class Sprint implements Iterable<Task> {

    private final int id;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private List<Task> taskList;

    public Sprint(int id, LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.id = id;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.taskList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
    
    public void addTask(Task task) {
        this.taskList.add(task);
    }

    public void removeTask(Task task) {
        this.taskList.remove(task);
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
    
    @Override
    public Iterator<Task> iterator() {
        return this.taskList.iterator();
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
}
