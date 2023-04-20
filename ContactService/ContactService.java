package ContactService;

import java.util.HashMap;

/*
 * Service class to create new contacts or update them. Utilizes the Contact class for mutation. First name, last name, phone, and address
 * are mutable. ID is used as key to find contacts. The Hash Map holds all of the current contacts.
 * 
 * @author Jeremy Baldner
 */

// Updated by removing iterator method and list. Added Hashmap -3/24/23
public class ContactService {
	
	// HashMap to hold contacts
	public static HashMap<String, Contact> contacts = new HashMap<String, Contact>();
	
	// Method to create a new contact -- Updated 3/24/23
	public static boolean addContact(Contact contact) {
		// if ID is not in the apointment hash map, add contact
		if(contacts.containsKey(contact.getId())) {
			throw new IllegalArgumentException("Contact ID already exists");
		}
		else {
			contacts.put(contact.getId(), contact);
			return true;
		}
	}
	
	// Method to delete contact -- Updated 3/24/23
	public static void deleteContact(String Id) {
		if(contacts.containsKey(Id)) {
			contacts.remove(Id);
		}
		else {
			throw new IllegalArgumentException("Contact ID not found");
		}
	}
	
	// Method to update first name 
	public static void setFirstName(String Id, String newFirstName) {
		if(contacts.containsKey(Id)) {
			contacts.get(Id).setFirstName(newFirstName);
		}
		else {
			throw new IllegalArgumentException("Contact ID not found");
		}
	}
	
	// Method to update last name
	public static void setLastName(String Id, String newLastName) {
		if(contacts.containsKey(Id)) {
			contacts.get(Id).setLastName(newLastName);
		}
		else {
			throw new IllegalArgumentException("Contact ID not found");
		}
	}
	
	// Method to update phone number
	public static void setPhone(String Id, String newPhoneWhoDis) {
		if(contacts.containsKey(Id)) {
			contacts.get(Id).setPhone(newPhoneWhoDis);
		}
		else {
			throw new IllegalArgumentException("Contact ID not found");
		}
	}
	
	// Method to update address
	public static void setAddress(String Id, String newAddress) {
		if(contacts.containsKey(Id)) {
			contacts.get(Id).setAddress(newAddress);
		}
		else {
			throw new IllegalArgumentException("Contact ID not found");
		}
	}
}
