package sysc4806.pm4y.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Prof extends User
{
    @OneToMany
    List<Project> projectList;

    public Prof() {
    }

    public Prof(final String email, final String password)
    {
        super(email, password);
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void addProject(Project p) {
        projectList.add(p);
    }
}