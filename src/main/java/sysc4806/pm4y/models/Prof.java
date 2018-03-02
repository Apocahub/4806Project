package sysc4806.pm4y.models;

import javax.persistence.Entity;

@Entity
public class Prof extends User
{
    public Prof(String email, String password)
    {
        super(email, password);
    }
}