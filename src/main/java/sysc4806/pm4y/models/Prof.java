package sysc4806.pm4y.models;

import sysc4806.pm4y.models.schedule.Schedule;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Prof extends User
{
    @OneToMany
    private List<Project> projectList;

    @OneToOne(targetEntity = Schedule.class)
    private Schedule schedule;

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

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}