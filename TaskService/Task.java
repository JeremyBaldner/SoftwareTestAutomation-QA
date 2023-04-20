package TaskService;

/*
 * Class to create new tasks and access them. Task name and description
 * are mutable. ID is not able to be mutated.
 * 
 * @author Jeremy Baldner
 */

public class Task {
	// contact variables
	private String Id;
	private String taskName;
	private String description;
		
	private Task(){}
	// creates a task with ID, name, and description
	public Task(String Id, String taskName, String description) {
		this();
		// parameters for appropriate contacts
		if(Id == null || Id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if(taskName == null || taskName.length() > 20) {
			throw new IllegalArgumentException("Invalid task name");
		}
		if(description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		
		// If no exceptions are thrown, task is created
		this.Id = Id;
		this.taskName = taskName;
		this.description = description;
	}
	
	// accessors
	public String getId() {
		return Id;
	}
	public String getTaskName() {
		return taskName;
	}
	public String getDescription() {
		return description;
	}
	
	// mutators -- all mutators contain the same criteria as the constructor
	public void setTaskName(String newTaskName) {
		if(newTaskName == null || newTaskName.length() > 20) {
			throw new IllegalArgumentException("Invalid task name");
		}
		else {
			this.taskName = newTaskName;
		}
	}
	public void setDescription(String newDescription) {
		if(newDescription == null || newDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		else {
			this.description = newDescription;
		}
	}
}
