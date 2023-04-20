package TaskService;

import java.util.HashMap;

/*
 * Service class to create new tasks or update them. Utilizes the Task class for mutation. Task name and description
 * are mutable. ID is used as key to find tasks. The Hash Map holds all of the current tasks.
 * 
 * @author Jeremy Baldner
 */

public class TaskService {
	// HashMap to hold contacts
	public static HashMap<String, Task> tasks = new HashMap<String, Task>();
	
	// Method to create a new contact -- Updated 3/24/23
	public static boolean addTask(Task task) {
		// if ID is not in the apointment hash map, add contact
		if(tasks.containsKey(task.getId())) {
			throw new IllegalArgumentException("Task ID already exists");
		}
		else {
			tasks.put(task.getId(), task);
			return true;
		}
	}
		
	// Method to delete a task
	public static void deleteTask(String Id) {	
		if(tasks.containsKey(Id)) {
			tasks.remove(Id);
		}
		else {
			throw new IllegalArgumentException("Task ID not found");
		}
	}
		
	// Method to update task name 
	public static void setTaskName(String Id, String newTaskName) {
		if(tasks.containsKey(Id)) {
			tasks.get(Id).setTaskName(newTaskName);
		}
		else {
			throw new IllegalArgumentException("Task ID not found");
		}
	}
		
	// Method to update task description
	public static void setDescription(String Id, String newDescription) {
		if(tasks.containsKey(Id)) {
			tasks.get(Id).setDescription(newDescription);
		}
		else {
			throw new IllegalArgumentException("Task ID not found");
		}
	}
}
