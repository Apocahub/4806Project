package sysc4806.pm4y.models;

import javax.persistence.Entity;
import java.util.*;

@Entity
public class Student extends User
{
    private boolean hasgroup;
    private List<Student> group = new ArrayList<Student>();

    public Student(final String email, final String password)
    {
        super(email, password);
    }

    public boolean isHasgroup() {
        return hasgroup;
    }

    public void setHasgroup(boolean hasgroup) {
        this.hasgroup = hasgroup;
    }

    public List<Student> getGroup() {
        return group;
    }

    public void setGroup(List<Student> group) {
        this.group = group;
    }

}