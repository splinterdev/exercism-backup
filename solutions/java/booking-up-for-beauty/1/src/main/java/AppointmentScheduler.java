import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class AppointmentScheduler {
    public LocalDateTime schedule(String appointmentDateDescription) {
        
        String[] field = appointmentDateDescription.split(" ");
        
        return LocalDateTime.of(Integer.parseInt(field[0].split("/")[2]), Integer.parseInt(field[0].split("/")[0]), Integer.parseInt(field[0].split("/")[1]), Integer.parseInt(field[1].split(":")[0]), Integer.parseInt(field[1].split(":")[1]), Integer.parseInt(field[1].split(":")[2]));
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return appointmentDate.isBefore(currentDateTime);
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        return appointmentDate.getHour() >= 12 && appointmentDate.getHour() < 18 ? true : false;
    }

    public String getDescription(LocalDateTime appointmentDate) {

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy h:mm");
        String appointment = appointmentDate.format(pattern);

        String monthName = appointmentDate.getMonth().toString();
        String dayName = appointmentDate.getDayOfWeek().toString();
        
        String[] fields = appointment.split(" ");
        String year = fields[0]; 
        String month = monthName.charAt(0) + monthName.substring(1, monthName.length()).toLowerCase() + " " + appointmentDate.getDayOfMonth();
        String day = dayName.charAt(0) + dayName.substring(1, dayName.length()).toLowerCase();
        String hours = fields[1];
        String meridiem = isAfternoonAppointment(appointmentDate) ? "PM." : "AM.";
        
        return "You have an appointment on " + day + ", " + month + ", " + year + ", at " + hours + " " + meridiem;
    }

    public LocalDate getAnniversaryDate() {
        return LocalDate.of(LocalDate.now().getYear(), 9, 15);
    }
}
