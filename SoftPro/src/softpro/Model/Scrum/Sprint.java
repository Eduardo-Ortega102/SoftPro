package softpro.Model.Scrum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sprint implements Iterable<UserStory> {

    private static final double FOCUS_FACTOR = 0.75;
    private static final double HOURS_OF_WORK_PER_WEEK = 40;
    private final int id;
    private final int weeks;
    private final LocalDate start_date;
    private final List<UserStory> userStoryList;

    public Sprint(int id, LocalDate fecha_inicio, int weeks) {
        this.id = id;
        this.weeks = weeks;
        this.start_date = fecha_inicio;
        this.userStoryList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public LocalDate getFecha_inicio() {
        return start_date;
    }

    public LocalDate getFecha_fin() throws Exception { 
        return LocalDate.from(start_date).plusWeeks(weeks);
    }

    public boolean addStory(UserStory story) {
        if (hoursOfStories() + story.getPoints() > hoursOfWorkInSprint()) return false;
        return userStoryList.add(story);
    }

    private int hoursOfStories() {
        int amountOfHours = 0;
        for (UserStory story : userStoryList)
            amountOfHours += story.getPoints();
        return amountOfHours;
    }

    private double hoursOfWorkInSprint() {
        return weeks * HOURS_OF_WORK_PER_WEEK * FOCUS_FACTOR;
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
