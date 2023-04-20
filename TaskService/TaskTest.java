package TaskService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
 * The task test j unit is used to test for the requirements set by the cliet.
 * This will test for task creation and specific task parameters. Task ID must 
 * be less than 10 characters and not null. Task name must be less than 20 
 * characters and not null. Task description must be less than 50 characters 
 * and not null. This test also checks that the name and description variables
 * can be mutated.
 * 
 * @author Jeremy Baldner 3/24/23
 */

class TaskTest {
	
	// Object to test mutators on -- added 3/24/23
	Task task = new Task("00000", "00000", "00000");
	
	// Makes sure a contact is created and can be returned
	@Test
	void testTaskClass() {
		Task task = new Task("12345", "Write code", "Blah blah blah blah blah blah blah blah");
		assertTrue(task.getId().equals("12345"));
		assertTrue(task.getTaskName().equals("Write code"));
		assertTrue(task.getDescription().equals("Blah blah blah blah blah blah blah blah"));
	}
	// Makes sure exception is thrown for ID being too long
	@Test
	void testTaskClassIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Task("12345678901", "Write code", "Blah blah blah blah blah blah blah blah");
		});	}
		
	// Makes sure exception is thrown for ID being null
	@Test
	void testTaskClassIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Task(null, "Write code", "Blah blah blah blah blah blah blah blah");
		});	}
		
	// Makes sure exception is thrown for task name being too long
	@Test
	void testTaskClassTaskNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Task("12345", "Write code Write code", "Blah blah blah blah blah blah blah blah");
		});	}
		
	// Makes sure exception is thrown for task name being null
	@Test
	void testTaskClassTaskNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Task("12345", null, "Blah blah blah blah blah blah blah blah");
		});	}
		
	// Makes sure exception is thrown for task name being too long when mutating 
	@Test
	void testTaskClassTaskNameMutatorTooLong(){
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			task.setTaskName("Work work work work work work");
		});	}
		
	// Makes sure exception is thrown for first name being null when mutating 
	@Test
	void testTaskClassFirstNameMutatorNull(){
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			task.setTaskName(null);
		});	}
	
	// Makes sure exception is thrown for description being too long
	@Test
	void testTaskClassDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Task("12345", "Write code", "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah");
		});	}
			
	// Makes sure exception is thrown for description being null
	@Test
	void testTaskClassDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Task("12345", "Write code", null);
		});	}
			
	// Makes sure exception is thrown for description being too long when mutating 
	@Test
	void testTaskClassDescriptionMutatorTooLong(){
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			task.setDescription("Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah");
		});	}
			
	// Makes sure exception is thrown for description being null when mutating 
	@Test
	void testTaskClassDescriptinoMutatorNull(){
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			task.setDescription(null);
		});	}
	
	// Make sure task name is mutatated when appropriate
	@Test
	void testTaskClassSetTaskName() {
		task.setTaskName("New Name");
		assertTrue(task.getTaskName().equals("New Name"));
	}
	
	// Make sure description is mutatated when appropriate
	@Test
	void testTaskClassSetDescription() {
		task.setDescription("New description");
		assertTrue(task.getDescription().equals("New description"));
	}
}
