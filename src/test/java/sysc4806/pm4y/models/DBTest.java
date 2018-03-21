package sysc4806.pm4y.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import sysc4806.pm4y.repositories.ProjectRepo;
import sysc4806.pm4y.repositories.UserRepo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DBTest {
    private Prof prof;
    private Project proj;
    @Autowired
    private UserRepo ur;
    @Autowired
    private ProjectRepo pr;

    @Before
    public void setup() {
        prof = new Prof("email", "password");
        proj = new Project("name", prof);
        ur.save(prof);
        pr.save(proj);
    }

    @Test
    public void testCreation() {
        Assert.assertNotNull(ur.findByEmail("email"));
        assertFalse(pr.findByProjectName("name").isEmpty());
    }

    @Test
    public void testProf() {
        assertEquals(prof, ur.findByEmail("email"));
    }

    @Test
    public void testProj() {
        assertSame(proj, pr.findByProjectName("name").get(0));
        assertSame(prof, pr.findByProjectName("name").get(0).getProfessor());
    }

}
