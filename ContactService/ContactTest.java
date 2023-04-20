package ContactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/*
 * The contact test j unit is used to test for the requirements set by the cliet.
 * This will test for contact creation and specific contact element parameters.
 * Contact ID must be less than 10 characters and not null. Contact first name 
 * must be less than 10 characters and not null. Contact last name must be less 
 * than 10 characters and not null. Contact phone number must be 10 characters and 
 * not null. Contact address must be less than 30 characters and not null.
 * 
 * @author Jeremy Baldner
 */
class ContactTest {
	
	// Object to test mutators on -- added 3/24/23
	Contact contact = new Contact("00000", "00000", "00000", "0000000000", "00000");
	
	// Makes sure a contact is created and can be returned
	@Test
	void testContactClass() {
		Contact contact = new Contact("12345", "Jeremy", "Baldner", "1234567890", "nunya business");
		assertTrue(contact.getId().equals("12345"));
		assertTrue(contact.getFirstName().equals("Jeremy"));
		assertTrue(contact.getLastName().equals("Baldner"));
		assertTrue(contact.getPhone().equals("1234567890"));
		assertTrue(contact.getAddress().equals("nunya business"));
	}
	
	// Makes sure exception is thrown for ID being too long
	@Test
	void testContactClassIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("12345678901", "Jeremy", "Baldner", "1234567890", "nunya business");
		});	}
	
	// Makes sure exception is thrown for ID being null
	@Test
	void testContactClassIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact(null, "Jeremy", "Baldner", "1234567890", "nunya business");
		});	}
	
	// Makes sure exception is thrown for first name being too long
	@Test
	void testContactClassFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("12345", "JeremyJeremy", "Baldner", "1234567890", "nunya business");
		});	}
	
	// Makes sure exception is thrown for first name being null
	@Test
	void testContactClassFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("12345", null, "Baldner", "1234567890", "nunya business");
		});	}
	
	// Makes sure exception is thrown for last name being too long
	@Test
	void testContactClassLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("12345", "Jeremy", "BaldnerBaldner", "1234567890", "nunya business");
		});	}
	
	// Makes sure exception is thrown for last name being null
	@Test
	void testContactClassLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("12345", "Jeremy", null, "1234567890", "nunya business");
		});	}
	
	// Makes sure exception is thrown for phone number being too long
	@Test
	void testContactClassPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("12345", "Jeremy", "Baldner", "12345678901", "nunya business");
		});	}
	
	// Makes sure exception is thrown for phone number being null
	@Test
	void testContactClassPhoneNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("12345", "Jeremy", "Baldner", null, "nunya business");
		});	}
	
	// Makes sure exception is thrown for address being too long
	@Test
	void testContactClassAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("12345", "Jeremy", "Baldner", "1234567890", "nunya business nunya business nunya");
		});	}
	
	// Makes sure exception is thrown for address being null
	@Test
	void testContactClassAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("12345", "Jeremy", "Baldner", "1234567890", null);
		});	}
	
	// -- All tests below added 3/24/23 --
	
	// Makes sure exception is thrown for phone number not being an integer
	@Test
	void testContactClassPhoneNotInt() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Contact("12345", "Jeremy", "Baldner", "123456789t", "nunya business");
		});	}
	
	// Makes sure exception is thrown for first name being too long when mutating 
	@Test
	void testContactClassFirstNameMutatorTooLong(){
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			contact.setFirstName("JeremyJeremy");});
	}
	
	// Makes sure exception is thrown for first name being null when mutating 
	@Test
	void testContactClassFirstNameMutatorNull(){
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			contact.setFirstName(null);});
	}
	
	// Makes sure exception is thrown for last name being too long when mutating 
	@Test
	void testContactClassLastNameMutatorTooLong(){
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			contact.setLastName("BaldnerBaldner");});
	}
	
	// Makes sure exception is thrown for last name being null when mutating 
	@Test
	void testContactClassLastNameMutatorNull(){
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			contact.setLastName(null);});
	}
	
	// Makes sure exception is thrown for phone number being too long when mutating 
	@Test
	void testContactClassPhoneMutatorTooLong(){
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			contact.setPhone("12345678901");});
	}
	
	// Makes sure exception is thrown for name being null when mutating 
	@Test
	void testContactClassPhoneMutatorNull(){
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			contact.setPhone(null);});
	}
	// add test for phone not int
	@Test
	void testContactClassPhoneMutatorNotInt() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			contact.setPhone("123456789t");});
	}
	
	// Makes sure exception is thrown for address being too long when mutating 
	@Test
	void testContactClassAddressMutatorTooLong(){
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			contact.setAddress("nunya business nunya business nunya");});
	}
	
	// Makes sure exception is thrown for address being null when mutating 
	@Test
	void testContactClassAddressMutatorNull(){
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			contact.setAddress(null);});
	}
	
	// Make sure first name is mutatated when appropriate
	@Test
	void testContactClassSetFirstName() {
		contact.setFirstName("Not Jeremy");
		assertTrue(contact.getFirstName().equals("Not Jeremy"));
	}
	
	// Make sure last name is mutatated when appropriate
	@Test
	void testContactClassSetLastName() {
		contact.setLastName("Not Bal");
		assertTrue(contact.getLastName().equals("Not Bal"));
	}
	// Make sure phone number is mutatated when appropriate
	@Test
	void testContactClassSetPhone() {
		contact.setPhone("1111111111");
		assertTrue(contact.getPhone().equals("1111111111"));
	}
	// Make sure address is mutatated when appropriate
	@Test
	void testContactClassSetAddress() {
		contact.setAddress("On the Edge");
		assertTrue(contact.getAddress().equals("On the Edge"));
	}
}
