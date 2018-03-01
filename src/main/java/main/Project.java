package main;
import javax.persistence.*;
import java.util.*;

@Entity
public class Project
{

    int id;
    String Projectname;
    List<Student> students;
    List<Student> applicants;
    Prof Professor;
    int maxstudents;

    public Project()
    {

    }

    public Project(String Projectname, Prof Professor)
    {
        this.Projectname = Projectname;
        this.Professor = Professor;
    }

    public String getProjectname() {
        return Projectname;
    }

    public void setProjectname(String projectname) {
        Projectname = projectname;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany
    public Prof getProfessor() {
        return Professor;
    }

    public void setProfessor(Prof professor) {
        Professor = professor;
    }


    public int getMaxstudents() {
        return maxstudents;
    }

    public void setMaxstudents(int maxstudents) {
        this.maxstudents = maxstudents;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<Student> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<Student> applicants) {
        this.applicants = applicants;
    }




}
