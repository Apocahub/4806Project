package sysc4806.pm4y.models;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {
	@Test
	public void testConstructor() {
		String email = "email";
		String password = "pass";
		User user = new User(email, password);
		Assert.assertEquals(email, user.getEmail());
		Assert.assertEquals(password, user.getPassword());
	}
	@Test
	public void setEmailNull() {
		User user = new User("Test", "Test");
		try {
			user.setEmail(null);
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("Email Cannot be a null value", e.getMessage());
		}
	}

	@Test
	public void setEmailEmpty() {
		User user = new User("Test", "Test");
		try {
			user.setEmail("");
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("Email must contain at least 1 character", e.getMessage());
		}
	}

	@Test
	public void setPasswordNull() {
		User user = new User("Test", "Test");
		try {
			user.setPassword(null);
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("Password Cannot be a null value", e.getMessage());
		}
	}

	@Test
	public void setPasswordEmpty() {
		User user = new User("Test", "Test");
		try {
			user.setPassword("");
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("Password must contain at least 1 character", e.getMessage());
		}
	}

	@Test
	public void setIDNull() {
		User user = new User("Test", "Test");
		try {
			user.setSessioniD(null);
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("sessioniD Cannot be a null value", e.getMessage());
		}
	}

	@Test
	public void setIDEmpty() {
		User user = new User("Test", "Test");
		try {
			user.setSessioniD("");
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("sessioniD must contain at least 1 character", e.getMessage());
		}
	}
}