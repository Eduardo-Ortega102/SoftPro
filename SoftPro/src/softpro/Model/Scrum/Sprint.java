package softpro.Model.Scrum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sprint implements Iterable<UserStory> {

    private final int id;
    private LocalDate fecha_inicio;
    private final List<UserStory> userStoryList;

    public Sprint(int id, LocalDate fecha_inicio) {
        this.id = id;
        this.fecha_inicio = fecha_inicio;
        this.userStoryList = new ArrayList<>();
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addUserStory(UserStory task) {
        this.userStoryList.add(task);
    }

    public void removeUserStory(UserStory task) {
        this.userStoryList.remove(task);
    }

    @Override
    public Iterator<UserStory> iterator() {
        return this.userStoryList.iterator();
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
