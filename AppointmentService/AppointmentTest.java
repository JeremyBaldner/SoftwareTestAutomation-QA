package AppointmentService;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
 * The appointment test j unit is used to test for the requirements set by the cliet.
 * This will test for appointment creation and specific appointment parameters. ID must 
 * be less than 11 characters and not null. Appointment date must be in the future
 * and not null. Task description must be less than 51 characters and not null. This 
 * test also checks that the date and description variables can be mutated.
 * 
 * @author Jeremy Baldner 3/31/23
 */

class AppointmentTest {
	// Object to test mutators on 
	Appointment appointment = new Appointment("00000", LocalDate.parse("2023-05-16"), "00000");
	LocalDate testDate = LocalDate.parse("2024-01-01");
		
	// Makes sure an appointment is created and can be returned
	@Test
	void testAppointmentClass() {
		Appointment appointment = new Appointment("12345", LocalDate.parse("2024-01-01"), "Blah");
		assertTrue(appointment.getId().equals("12345"));
		assertTrue(appointment.getAppointmentDate().isEqual(testDate));
		assertTrue(appointment.getAppointmentDescription().equals("Blah"));
	}
	// Makes sure exception is thrown for ID being too long
	@Test
	void testAppointmentClassIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Appointment("12345678901", LocalDate.parse("2024-01-01"), "Blah");
		});	}
		
	// Makes sure exception is thrown for ID being null
	@Test
	void testAppointmentClassIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Appointment(null, LocalDate.now(), "Blah");
		});	}
			
	// Makes sure exception is thrown for appointment in past
	@Test
	void testAppointmentClassPastDate() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Appointment("0000", LocalDate.parse("2020-01-01"), "Blah");
		});	}
			
	// Makes sure exception is thrown for appointment date being null
	@Test
	void testAppointmentClassDateNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Appointment("0000", null, "Blah");
		});	}
			
	// Makes sure exception is thrown for appointment date in past when mutating 
	@Test
	void testAppointmentClassDateMutatorInPast(){
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			appointment.setAppointmentDate(LocalDate.parse("2020-01-01"));
		});	}
			
	// Makes sure exception is thrown for appointment date being null when mutating 
	@Test
	void testAppointmentClassDateMutatorNull(){
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			appointment.setAppointmentDate(null);
		});	}
		
	// Makes sure exception is thrown for description being too long
	@Test
	void testAppointmentClassDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Appointment("00000", LocalDate.now(), "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah");
		});	}
				
	// Makes sure exception is thrown for description being null
	@Test
	void testApointmentClassDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Appointment("12345", LocalDate.now(), null);
		});	}
				
	// Makes sure exception is thrown for description being too long when mutating 
	@Test
	void testAppointmentClassDescriptionMutatorTooLong(){
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			appointment.setAppointmentDescription("Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah");
		});	}
				
	// Makes sure exception is thrown for description being null when mutating 
	@Test
	void testAppointmentClassDescriptinoMutatorNull(){
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			appointment.setAppointmentDescription(null);
		});	}
		
	// Make sure appointment date is mutatated when appropriate
	@Test
	void testAppointmentClassSetTaskName() {
		appointment.setAppointmentDate(LocalDate.now());
		assertTrue(appointment.getAppointmentDate().isEqual(LocalDate.now()));
	}
		
	// Make sure description is mutatated when appropriate
	@Test
	void testAppointmentClassSetDescription() {
		appointment.setAppointmentDescription("New description");
		assertTrue(appointment.getAppointmentDescription().equals("New description"));
	}
}
