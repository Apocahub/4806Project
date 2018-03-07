package sysc4806.pm4y.models;

import org.junit.Assert;
import org.junit.Test;

public class ProjectCoordinatorTest {

    private ProjectCoordinator pc;

    @Test
    public void testConstructor() {
        String email = "email";
        String password = "pass";
        pc = new ProjectCoordinator(email, password);
        Assert.assertEquals(email, pc.getEmail());
        Assert.assertEquals(password, pc.getPassword());
    }
}
