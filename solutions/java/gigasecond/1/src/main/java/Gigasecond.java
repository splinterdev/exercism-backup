import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {

    private static final int BILLION = 1_000_000_000;
    private LocalDateTime gigaSecondDate;
    
    public Gigasecond(LocalDate moment) {
        this.gigaSecondDate = moment.atStartOfDay().plusSeconds(BILLION);
    }

    public Gigasecond(LocalDateTime moment) {
        this.gigaSecondDate = moment.plusSeconds(BILLION);
    }

    public LocalDateTime getDateTime() {
        return gigaSecondDate;
    }
}
