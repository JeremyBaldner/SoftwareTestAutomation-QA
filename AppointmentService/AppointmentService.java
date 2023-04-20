package AppointmentService;
import java.time.LocalDate;
import java.util.HashMap;

/*
 * Service class to create new appointments or update them. Utilizes the Appointment class 
 * for mutation. apppointment date and description are mutable. ID is used as key to find 
 * appointments. The hash map holds all of the current appointments.
 * 
 * @author Jeremy Baldner
 */

public class AppointmentService {
	// HashMap to hold appointments
	public static HashMap<String, Appointment> appointments = new HashMap<String, Appointment>();
		
	// Method to create a new appointment
	public static boolean addAppointment(Appointment appointment) {
		// if ID is not in the apointment hash map, add appointment
		if(appointments.containsKey(appointment.getId())) {
			throw new IllegalArgumentException("Appointment ID already exists");
		}
		else {
			appointments.put(appointment.getId(), appointment);
			return true;
		}
	}
		
	// Method to delete an appointment
	public static void deleteAppointment(String Id) {	
		if(appointments.containsKey(Id)) {
			appointments.remove(Id);
		}
		else {
			throw new IllegalArgumentException("Appointment ID not found");
		}
	}
		
	// Method to update appointment date 
	public static void setAppointmentDate(String Id, LocalDate date) {
		if(appointments.containsKey(Id)) {
			appointments.get(Id).setAppointmentDate(date);
		}
		else {
			throw new IllegalArgumentException("Appointment ID not found");
		}
	}
		
	// Method to update appointment description
	public static void setAppointmentDescription(String Id, String newDescription) {
		if(appointments.containsKey(Id)) {
			appointments.get(Id).setAppointmentDescription(newDescription);
		}
		else {
			throw new IllegalArgumentException("Appointment ID not found");
		}
	}
}
