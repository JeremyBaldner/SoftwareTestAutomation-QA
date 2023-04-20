package AppointmentService;
import java.time.LocalDate;

/*
 * Class to create new appointment objects and access their values. 
 * Appointment date and description is mutable. ID is not able to be mutated.
 * 
 * @author Jeremy Baldner
 */

public class Appointment {
	// Appointment variables
	private String Id;
	private LocalDate appointmentDate;
	private String appointmentDescription;
			
	private Appointment(){}
	// creates an appointment with ID, date, and description
	public Appointment(String Id, LocalDate date, String description) {
		this();
		// parameters for appropriate appointments
		if(Id == null || Id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if(date == null || date.isBefore(LocalDate.now()) ) {
			throw new IllegalArgumentException("Invalid date");
		}
		if(description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
			
		// If no exceptions are thrown, appointment is created
		this.Id = Id;
		this.appointmentDate = date;
		this.appointmentDescription = description;
	}
		
	// accessors
	public String getId() {
		return Id;
	}
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public String getAppointmentDescription() {
		return appointmentDescription;
	}
		
	// mutators -- all mutators contain the same criteria as the constructor
	public void setAppointmentDate(LocalDate newDate) {
		if(newDate == null || newDate.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("Invalid date");
		}
		else {
			this.appointmentDate = newDate;
		}
	}
	public void setAppointmentDescription(String newDescription) {
		if(newDescription == null || newDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		else {
			this.appointmentDescription = newDescription;
		}
	}
}
