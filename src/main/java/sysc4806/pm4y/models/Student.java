package sysc4806.pm4y.models;

import javax.persistence.Entity;
import java.util.*;

@Entity
public class Student extends User
{
    private boolean hasgroup;
    private List<Student> group = new ArrayList<Student>();
    public Student(final String first,final String last)
    {
        super(first, last);
    }

}