package sysc4806.pm4y.models.schedule;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class TimeSlot {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String id;
	private String time;

	@ElementCollection(targetClass=String.class)
	private List<String> checkedValues;

	public TimeSlot(String time) {
		this.time = time;
		checkedValues = Arrays.asList(new String[]{"false","false","false","false","false"});
	}

	public String getId() {
		return id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<String> getCheckedValues() {
		return checkedValues;
	}

	public void setCheckedValues(List<String> checkedValues) {
		this.checkedValues = checkedValues;
	}
}
