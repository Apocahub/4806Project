package sysc4806.pm4y.models;

import javax.persistence.Entity;

@Entity
public class Prof extends User
{
    public Prof(final String email, final String password)
    {
        super(email, password);
    }
}