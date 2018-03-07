package sysc4806.pm4y.models;

import org.junit.Assert;
import org.junit.Test;

public class ProfTest {

    private Prof p;

    @Test
    public void testConstructor() {
        String email = "email";
        String password = "pass";
        p = new Prof(email, password);
        Assert.assertEquals(email, p.getEmail());
        Assert.assertEquals(password, p.getPassword());
    }
}
