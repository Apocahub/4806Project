package sysc4806.pm4y.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student extends User
{
    @ManyToOne(targetEntity = Project.class, cascade = CascadeType.ALL)
    private Project project;

    public Student() {}

    public Student(final String email, final String password) {
        super(email, password);
    }

    public Project getProject() {
        return project;
    }
    public void setProject(Project p) {
        this.project = p;
    }
}