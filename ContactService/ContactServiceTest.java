package ContactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

/*
* The contact service test j unit is used to test for the requirements set by the cliet.
* This will test for contact creation, deletion, unique ID's, and mutation of the first name,
* last name, phone number, and address.
* 
*  @author Jeremy Baldner
*/
@TestMethodOrder(OrderAnnotation.class)
class ContactServiceTest {

	// Makes sure a contact is created and can be returned
	@Test
	@Order(1)
	void testContactServiceClass() {
		ContactService.addContact(new Contact("12345", "Jeremy", "Baldner", "1234567890", "nunya business"));
		assertTrue(ContactService.contacts.get("12345").getId().equals("12345"));
		assertTrue(ContactService.contacts.get("12345").getFirstName().equals("Jeremy"));
		assertTrue(ContactService.contacts.get("12345").getLastName().equals("Baldner"));
		assertTrue(ContactService.contacts.get("12345").getPhone().equals("1234567890"));
		assertTrue(ContactService.contacts.get("12345").getAddress().equals("nunya business"));
	}
	
	@Test
	@Order(7)
	void testContactServiceClassDeleteContact() {
		ContactService.deleteContact("12345");
		assertTrue(ContactService.contacts.size() < 1);
	}
		
	// Makes sure exception is thrown for ID already used
	@Test
	@Order(2)
	void testContactServiceClassIdAlreadyCreated() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
		ContactService.addContact(new Contact("12345", "J", "B", "0000000000", "nunyanunyanunya"));
		});	}
		
	// Makes sure first name is mutated
	@Test
	@Order(3)
	void testContactClassMutateFirstName() {
		ContactService.setFirstName("12345", "Not Jeremy");
		assertTrue(ContactService.contacts.get("12345").getFirstName().equals("Not Jeremy"));	
	}
	
	// Makes sure last name is mutated
	@Test
	@Order(4)
	void testContactClassMutateLastName() {
		ContactService.setLastName("12345", "Not Bald");
		assertTrue(ContactService.contacts.get("12345").getLastName().equals("Not Bald"));	
	}
	
	// Makes sure phone number is mutated
	@Test
	@Order(5)
	void testContactClassMutatePhoneNumber() {
		ContactService.setPhone("12345", "1111111111");
		assertTrue(ContactService.contacts.get("12345").getPhone().equals("1111111111"));	
	}
	
	// Makes sure address is mutated
	@Test
	@Order(6)
	void testContactClassMutateAddress() {
		ContactService.setAddress("12345", "bisbisbisbis");
		assertTrue(ContactService.contacts.get("12345").getAddress().equals("bisbisbisbis"));	
	}	
	
	// Updated test cases to include exceptions thrown -3/24/23
	
	// Makes sure exception is thrown for ID already used
	@Test
	void testContactServiceClassMutateFirstNameIdNotFound() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
		ContactService.setFirstName("00000", "J");
		});	}
	// Makes sure exception is thrown for ID already used
	@Test
	void testContactServiceClassMutateLastNameIdNotFound() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
		ContactService.setLastName("00000", "J");
		});	}
	// Makes sure exception is thrown for ID already used
	@Test
	void testContactServiceClassMutatePhoneIdNotFound() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
		ContactService.setPhone("00000", "1234567890");
		});	}
	// Makes sure exception is thrown for ID already used
	@Test
	void testContactServiceClassMutateAddressIdNotFound() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
		ContactService.setAddress("00000", "J");
		});	}
	// Makes sure exception is thrown for ID already used
	@Test
	void testContactServiceClassDeleteContactIdNotFound() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
		ContactService.deleteContact("00000");
		});	}
		
}
