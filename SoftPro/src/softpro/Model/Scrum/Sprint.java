package softpro.Model.Scrum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sprint implements Iterable<UserStory> {

    private static final double FOCUS_FACTOR = 0.75;
    private static final double HOURS_OF_WORK_PER_WEEK = 40;
    private final int id;
    private int weeks;
    private int sizeOfTeam;
    private LocalDate start_date;
    private final List<UserStory> stories;

    public Sprint(int id, LocalDate fecha_inicio, int weeks, int sizeOfTeam) {
        this.id = id;
        this.weeks = weeks;
        this.sizeOfTeam = sizeOfTeam;
        this.start_date = fecha_inicio;
        this.stories = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getWeeks() {
        return weeks;
    }

    public void setWeeks(int weeks) {
        this.weeks = weeks;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getFecha_inicio() {
        return start_date;
    }

    public LocalDate getFecha_fin() throws Exception { 
        return LocalDate.from(start_date).plusWeeks(weeks);
    }

    public boolean addStory(UserStory story) {
        if (storiesDuration() + story.getPoints() > hoursOfWork()) return false;
        return stories.add(story);
    }

    public int storiesDuration() {
        int amountOfHours = 0;
        for (UserStory story : stories) amountOfHours += story.getPoints();
        return amountOfHours;
    }

    public double hoursOfWork() {
        return HOURS_OF_WORK_PER_WEEK * weeks * sizeOfTeam * FOCUS_FACTOR;
    }
    
    public boolean removeUserStory(UserStory story) {
        return this.stories.remove(story);
    }
    
    public UserStory findStory(int id){
        for (UserStory story : stories)
            if (story.getId() == id) return story;
        return null;
    }

    @Override
    public Iterator<UserStory> iterator() {
        return this.stories.iterator();
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

    public void incrementTeamSize() {
        this.sizeOfTeam++;
    }

    public void decrementTeamSize() {
        this.sizeOfTeam--;
    }

}
