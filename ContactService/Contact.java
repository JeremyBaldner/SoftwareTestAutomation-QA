package ContactService;

/*
 * Class to create new contacts and access them. First name, last name, phone, and address
 * are mutable. ID is not able to be mutated.
 * 
 * @author Jeremy Baldner
 */

public class Contact {
	
	// contact variables
	private String Id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	private Contact(){}
	// creates a contact with ID, fist and last name, phone number, and address
	public Contact(String Id, String firstName, String lastName, String phone, String address) {
		this();
		// parameters for appropriate contacts
		if(Id == null || Id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if(phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		// Try statement added to make sure the phone number is a string of integers -3/24/23
		try {
			Integer.parseInt(phone);
		} catch(Exception e){
			throw new IllegalArgumentException("Only use numbers");
		}
	
		// If no exceptions are thrown, contact is created
		this.Id = Id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	// accessors
	public String getId() {
		return Id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	
	// mutators -- Updated mutators to have the same exceptions as constructor -3/24/23
	public void setFirstName(String newFirstName) {
		if(newFirstName == null || newFirstName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		else {
			this.firstName = newFirstName;
		}
	}
	public void setLastName(String newLastName) {
		if(newLastName == null || newLastName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		else {
			this.lastName = newLastName;
		}
	}
	public void setPhone(String newPhone) {
		if(newPhone == null || newPhone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		try {
			Integer.parseInt(newPhone);
		} catch(Exception e){
			throw new IllegalArgumentException("Only use numbers");
		}
		this.phone = newPhone;
	}
	public void setAddress(String newAddress) {
		if(newAddress == null || newAddress.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		else {
			this.address = newAddress;
		}
	}	
}
