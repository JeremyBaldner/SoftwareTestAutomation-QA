package TaskService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

/*
* The task service test j unit is used to test for the requirements set by the cliet.
* This will test for task creation, deletion, finding task by ID, and mutation of the 
* task name, and description.
* 
*  @author Jeremy Baldner 3/24/23
*/

@TestMethodOrder(OrderAnnotation.class)
class TaskServiceTest {
	// Makes sure a contact is created and can be returned
	@Test
	@Order(1)
	void testTaskServiceClass() {
		TaskService.addTask(new Task("12345", "Write code", "Blah blah"));
		assertTrue(TaskService.tasks.get("12345").getId().equals("12345"));
		assertTrue(TaskService.tasks.get("12345").getTaskName().equals("Write code"));
		assertTrue(TaskService.tasks.get("12345").getDescription().equals("Blah blah"));
	}
	
	// Makes sure the task is deleted
	@Test
	@Order(7)
	void testTaskServiceClassDeleteContact() {
		TaskService.deleteTask("12345");
		assertTrue(TaskService.tasks.size() < 1);
	}
			
	// Makes sure exception is thrown for ID already used
	@Test
	@Order(2)
	void testTaskServiceClassIdAlreadyCreated() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
		TaskService.addTask(new Task("12345", "Write code", "Blah blah"));
		});	}
			
	// Makes sure task name is mutated
	@Test
	@Order(3)
	void testTaskClassMutateTaskName() {
		TaskService.setTaskName("12345", "Go swimming");
		assertTrue(TaskService.tasks.get("12345").getTaskName().equals("Go swimming"));	
	}
		
	// Makes sure description is mutated
	@Test
	@Order(4)
	void testTaskClassMutateDescription() {
		TaskService.setDescription("12345", "Not Blah");
		assertTrue(TaskService.tasks.get("12345").getDescription().equals("Not Blah"));	
	}
		
	// Makes sure exception is thrown for ID not found
	@Test
	void testTaskServiceClassMutateTaskNameIdNotFound() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
		TaskService.setTaskName("00000", "J");
		});	}
	
	// Makes sure exception is thrown for ID not found
	@Test
	void testTaskServiceClassMutateDescriptionIdNotFound() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
		TaskService.setDescription("00000", "J");
		});	}

	// Makes sure exception is thrown for ID not found
	@Test
	void testTaskServiceClassDeleteTaskIdNotFound() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
		TaskService.deleteTask("00000");
		});	}
}
