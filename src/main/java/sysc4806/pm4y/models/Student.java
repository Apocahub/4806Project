package sysc4806.pm4y.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student extends User
{
    @ManyToOne(targetEntity = Project.class, cascade = CascadeType.ALL)
    private Project project;

    private EngineeringStream engineeringStream;

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

    public EngineeringStream getEngineeringStream() {
        return engineeringStream;
    }

    public void setEngineeringStream(EngineeringStream engineeringStream) {
        this.engineeringStream = engineeringStream;
    }
}