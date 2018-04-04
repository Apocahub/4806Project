package sysc4806.pm4y.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class ProjectTest {

    private String name;
    private Prof prof;
    private Project p;

    @Before
    public void setUp() {
        name = "name";
        prof = new Prof();
    }

    @Test
    public void testConstructor() {
        p = new Project(name, prof);
        Assert.assertSame(prof, p.getProfessor());
        Assert.assertEquals(name, p.getProjectName());
    }

    @Test
    public void setDescriptionNull() {
        p = new Project(name, prof);
        try {
            p.setDescription(null);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Description Cannot be a null value", e.getMessage());
        }
    }

    @Test
    public void setDescriptionEmpty() {
        p = new Project(name, prof);
        try {
            p.setDescription("");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Description must contain at least 1 character", e.getMessage());
        }
    }

    @Test
    public void setDescription() {
        p = new Project(name, prof);
        try {
            p.setDescription("project");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("project", p.getDescription());
        }
    }

    @Test
    public void setProjectNameNull() {
        p = new Project(name, prof);
        try {
            p.setProjectName(null);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Cannot set a projectName to a null value", e.getMessage());
        }
    }

    @Test
    public void setProjectNameEmpty() {
        p = new Project(name, prof);
        try {
            p.setProjectName("");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Cannot set a projectName to an empty String", e.getMessage());
        }
    }

    @Test
    public void setProjectName() {
        p = new Project(name, prof);
        try {
            p.setProjectName("name");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("name", p.getProjectName());
        }
    }

    @Test
    public void setIdZero() {
        p = new Project(name, prof);
        try {
            p.setId(0);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Id Cannot be a null value", e.getMessage());
        }
    }

    @Test
    public void setId() {
        p = new Project(name, prof);
        try {
            p.setId(1);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(1, p.getId());
        }
    }

    @Test
    public void setMaxStudentsZero() {
        p = new Project(name, prof);
        try {
            p.setMaxStudents(0);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("The maximum number of students must be a positive value greater than 0", e.getMessage());
        }
    }

    @Test
    public void setMaxStudents() {
        p = new Project(name, prof);
        try {
            p.setMaxStudents(1);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(1, p.getMaxStudents());
        }
    }

    @Test
    public void setProfessorNull() {
        p = new Project(name, prof);
        try {
            p.setProfessor(null);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Cannot set a professor to a null value", e.getMessage());
        }
    }

    @Test
    public void setProfessor() {
        p = new Project(name, prof);
        try {
            p.setProfessor(prof);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(prof, p.getProfessor());
        }
    }

    @Test
    public void setStudentsNull() {
        p = new Project(name, prof);
        try {
            p.setStudents(null);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Cannot set students to a null List", e.getMessage());
        }
    }

    @Test
    public void setStudents() {
        p = new Project(name, prof);
        List<Student> s = new ArrayList<>();
        try {
            p.setStudents(s);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("The list of students must contain at least 1 non-null student", e.getMessage());
        }
    }

    @Test
    public void setApplicantsNull() {
        p = new Project(name, prof);
        try {
            p.setApplicants(null);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Cannot set applicants to a null List", e.getMessage());
        }
    }

    @Test
    public void setApplicants() {
        p = new Project(name, prof);
        List<Student> s = new ArrayList<>();
        try {
            p.setApplicants(s);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("The list of applicants must contain at least non-null applicant", e.getMessage());
        }
    }
}
