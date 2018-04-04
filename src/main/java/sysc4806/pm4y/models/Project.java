package sysc4806.pm4y.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public final class Project
{
    public static final String MODEL_NAME = "project";

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	@OneToMany(targetEntity = Student.class)
	private List<Student> students;
	@OneToMany(targetEntity = Student.class)
    private List<Student> applicants;

	@ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "streams", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "stream", nullable = false)
    @Enumerated(EnumType.STRING)
	private List<EngineeringStream> engineeringStreams;

	@ManyToOne(targetEntity = Prof.class)
	private Prof professor;
	private String projectName;
    private int maxStudents;
    private String description;
    private LocalDateTime due;
    public boolean isArchived;

    public Project() {
        isArchived = false;
    }

    public Project(final String projectName, final Prof professor)
    {
        isArchived = false;
        setProjectName(projectName);
        setProfessor(professor);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(final String projectName) throws IllegalArgumentException {
        if(Objects.isNull(projectName)) {
        	throw new IllegalArgumentException("Cannot set a projectName to a null value");
		}
		if(projectName.isEmpty()) {
        	throw new IllegalArgumentException("Cannot set a projectName to an empty String");
		}
    	this.projectName = projectName;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public Prof getProfessor() {
        return professor;
    }

    public void setProfessor(final Prof professor) throws IllegalArgumentException {
    	if(Objects.isNull(professor)) {
    		throw new IllegalArgumentException("Cannot set a professor to a null value");
		}
        this.professor = professor;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(final int maxStudents) throws IllegalArgumentException {
    	if(maxStudents < 0) {
    		throw new IllegalArgumentException("The maximum number of students must be a positive value greater than 0");
		}
        this.maxStudents = maxStudents;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public void setStudents(final List<Student> students) throws IllegalArgumentException {
    	if(Objects.isNull(students)) {
    		throw new IllegalArgumentException("Cannot set students to a null List");
		}
		students.removeIf(s -> Objects.isNull(s));
		if(students.isEmpty()) {
    		throw new IllegalArgumentException("The list of students must contain at least 1 non-null student");
		}
        this.students = students;
    }

    public List<Student> getApplicants() {
        return new ArrayList<>(applicants);
    }

    public void setApplicants(final List<Student> applicants) {
		if(Objects.isNull(applicants)) {
			throw new IllegalArgumentException("Cannot set applicants to a null List");
		}
		applicants.removeIf(a -> Objects.isNull(a));
		if(applicants.isEmpty()) {
			throw new IllegalArgumentException("The list of applicants must contain at least non-null applicant");
		}
        this.applicants = applicants;
    }

    public void setDue(LocalDateTime dueDate) {
        this.due = dueDate;
    }

    public String getDueDateFancy() {
        String s = "Project Due: ";
        s = s + (due != null ? due.toLocalDate() + " @ " + due.toLocalTime() : "Project due date not yet set!");
        return s;
    }

    public List<EngineeringStream> getEngineeringStreams() {
        return engineeringStreams;
    }

    public void setEngineeringStreams(List<EngineeringStream> engineeringStreams) {
        this.engineeringStreams = engineeringStreams;
    }

    public String getStreamNames() {
        String s = "";
        if(engineeringStreams ==  null || engineeringStreams.isEmpty()) return "Any";
        for (EngineeringStream stream : engineeringStreams) {
            s = s + stream.getStreamName() + ", ";
        }
        return s.substring(0, s.length() - 2);
    }

}
