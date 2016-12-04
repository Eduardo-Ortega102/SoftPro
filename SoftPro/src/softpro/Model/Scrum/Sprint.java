package softpro.Model.Scrum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static java.time.temporal.ChronoUnit.DAYS;

public class Sprint implements Iterable<UserStory> {

    private final int id;
    private final LocalDate start_date;
    private final List<UserStory> userStoryList;

    public Sprint(int id, LocalDate fecha_inicio) {
        this.id = id;
        this.start_date = fecha_inicio;
        this.userStoryList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public LocalDate getFecha_inicio() {
        return start_date;
    }

    //--esto está mal, hay que buscar el camino critico porque hay historias que
    //--se pueden hacer concurrentemente
    public LocalDate getFecha_fin() throws Exception { 
        LocalDate end_date = LocalDate.from(start_date);
        for (UserStory story : userStoryList) {
            end_date = end_date.plusDays(story.getPoints());
            if (DAYS.between(start_date, end_date) > 27)
                throw new Exception("El sprint dura más de 27 días");
        }
        return end_date;
    }

    public boolean addStory(UserStory story) {
        return this.userStoryList.add(story);
    }

    public boolean removeUserStory(UserStory story) {
        return this.userStoryList.remove(story);
    }
    
    public UserStory findStory(int id){
        for (UserStory story : userStoryList)
            if (story.getId() == id) return story;
        return null;
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
