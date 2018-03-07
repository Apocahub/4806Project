package sysc4806.pm4y.models;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    private Student s;

    @Test
    public void testConstructor() {
        String email = "email";
        String password = "pass";
        s = new Student(email, password);
        Assert.assertEquals(email, s.getEmail());
        Assert.assertEquals(password, s.getPassword());
    }
}
