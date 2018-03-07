package sysc4806.pm4y.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student extends User
{
    @OneToOne(targetEntity = Student.class, cascade = CascadeType.ALL)
    private List<Student> group = new ArrayList<>();
    private boolean hasgroup;
    public Student(final String first,final String last)
    {
        super(first, last);
    }

}