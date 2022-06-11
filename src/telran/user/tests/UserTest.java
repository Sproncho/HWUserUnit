package telran.user.tests;

import org.junit.jupiter.api.*;
import telran.user.model.User;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
	User user;
	String email = "peter@gmail.com";
	String password = "1Ll!2345";

	@BeforeEach
	void setUp() throws Exception {
		user = new User(email, password);
	}

	@Test
	void testCorrectEmail() {
		user.setEmail("peter@yahoo.com");
		assertEquals("peter@yahoo.com", user.getEmail());
	}

	@Test
	void testWithoutAt() {
		user.setEmail("peter.yahoo.com");
		assertEquals(email, user.getEmail());
	}

	@Test
	void testManyAt() {
		user.setEmail("peter@ya@hoo.com");
		assertEquals(email, user.getEmail());
	}

	@Test
	void testDotAfterAt() {
		user.setEmail("peter@yahoocom");
		assertEquals(email, user.getEmail());
	}

	@Test
	void testLastDot() {
		user.setEmail("peter@yahoo.com.");
		assertEquals(email, user.getEmail());
		user.setEmail("peter@yahoo.co.m");
		assertEquals(email, user.getEmail());
	}

	@Test
	void testIncorrectSymbol() {
		user.setEmail("pet!er@yahoo.com");
		assertEquals(email, user.getEmail());
	}

	@Test
	void testSetUserPassword(){
		user.setPassword("1Ll!2345");
		assertEquals("1Ll!2345", user.getPassword());
	}
	@Test
	void testPasswordLength(){
		user.setPassword("1Ll!234");
		assertEquals(password,user.getPassword());
	}

	@Test
	void testPasswordContainsUppercase(){
		user.setPassword("1ll!2345");
		assertEquals(password,user.getPassword());
	}

	@Test
	void testPasswordContainsLowercase(){
		user.setPassword("1LL!2345");
		assertEquals(password,user.getPassword());
	}

	@Test
	void testPasswordContainsDigit(){
		user.setPassword("zll!zzzz");
		assertEquals(password,user.getPassword());
	}

	@Test
	void testPasswordContainsSpecial(){
		user.setPassword("1ll22345");
		assertEquals(password,user.getPassword());
	}

}
