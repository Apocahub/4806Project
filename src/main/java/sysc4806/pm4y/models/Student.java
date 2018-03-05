package sysc4806.pm4y.models;

import javax.persistence.Entity;

@Entity
public final class Student extends User
{
    public Student(final String first,final String last)
    {
        super(first, last);
    }

}