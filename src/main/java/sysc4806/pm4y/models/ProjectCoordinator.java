package sysc4806.pm4y.models;

import javax.persistence.Entity;

@Entity
public final class ProjectCoordinator extends User
{
    public ProjectCoordinator(final String email,final String password)
    {
        super(email, password);
    }
}
