package softpro.Controller;
import java.time.LocalDate;

public class CustomDate{
    public LocalDate deliverDate(int weeks){
        return LocalDate.now().plusWeeks(weeks);
    }

    public LocalDate now() {
        return LocalDate.now();
    }
}
