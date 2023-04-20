package AppointmentService;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
* The appointment service test j unit is used to test for the requirements set by the client.
* This will test for appointment creation, deletion, finding appointment by ID, and mutation of the 
* date, and description.
* 
*  @author Jeremy Baldner 3/31/23 -- BeforeAll and Before Each method added 4/4/23
*/

class AppointmentServiceTest {
	private static String testID = "12345";
	private static String testFakeID = "00000";
	private static LocalDate testDate = LocalDate.parse("3000-01-01");
	private static LocalDate currentDate = LocalDate.now();
	private static String testDescription = "description";
	private static String testDescription2 = "new description";
	
	// creates objects to test. Only appointment with ID 12345 will be tested multiple times.
	// Appointment 11111 is only for deletion test
	@BeforeAll
	static void init(){
		AppointmentService.addAppointment(new Appointment(testID, testDate, testDescription));
		AppointmentService.addAppointment(new Appointment("11111", testDate, testDescription));
	}
	
	// Makes sure appointment with ID 12345 is the same for each test
	@BeforeEach
	void setUp() {
		AppointmentService.setAppointmentDate(testID, testDate);
		AppointmentService.setAppointmentDescription(testID, testDescription);
	}
	
	// Makes sure an appointment is created and can be returned
	@Test
	void testAppointmentServiceClass() {
		assertTrue(AppointmentService.appointments.get(testID).getId().equals(testID));
		assertTrue(AppointmentService.appointments.get(testID).getAppointmentDate().equals(testDate));
		assertTrue(AppointmentService.appointments.get(testID).getAppointmentDescription().equals(testDescription));
	}

	// Makes sure the appointment is deleted
	@Test
	void testAppointmentServiceClassDeleteAppointment() {
		AppointmentService.deleteAppointment("11111");
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			AppointmentService.deleteAppointment("11111");});
	}
			
	// Makes sure exception is thrown for ID already used
	@Test
	void testAppointmentServiceClassIdAlreadyCreated() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
		AppointmentService.addAppointment(new Appointment(testID, LocalDate.now(), testDescription));
		});	}
			
	// Makes sure appointment date is mutated
	@Test
	void testAppointmentServiceClassMutateDate() {
		AppointmentService.setAppointmentDate(testID, currentDate);
		assertTrue(AppointmentService.appointments.get(testID).getAppointmentDate().equals(currentDate));	
	}
	
	// Makes sure description is mutated
	@Test
	void testAppointmentServiceClassMutateDescription() {
		AppointmentService.setAppointmentDescription(testID, testDescription2);
		assertTrue(AppointmentService.appointments.get(testID).getAppointmentDescription().equals(testDescription2));	
	}
		
	// Makes sure exception is thrown for ID not found
	@Test
	void testAppointmentServiceClassMutateDateIdNotFound() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
		AppointmentService.setAppointmentDate(testFakeID, LocalDate.now());
		});	}
	
	// Makes sure exception is thrown for ID not found
	@Test
	void testTaskServiceClassMutateDescriptionIdNotFound() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
		AppointmentService.setAppointmentDescription(testFakeID, "J");
		});	}

	// Makes sure exception is thrown for ID already used
	@Test
	void testAppointmentServiceClassDeleteAppointmentIdNotFound() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
		AppointmentService.deleteAppointment(testFakeID);
		});	}
}
