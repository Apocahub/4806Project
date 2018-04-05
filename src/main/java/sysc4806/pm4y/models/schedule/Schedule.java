package sysc4806.pm4y.models.schedule;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Schedule {
	public static final String HEADERS[] = {"","Monday", "Tuesday","Wednesday", "Thursday","Friday"};
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String id;
	@OneToMany(targetEntity = TimeSlot.class)
	private List<TimeSlot> timeSlotList;

	public Schedule() {
		timeSlotList = new ArrayList<>();
		timeSlotList.add(new TimeSlot("08:00-09:00"));
		timeSlotList.add(new TimeSlot("09:00-10:00"));
		timeSlotList.add(new TimeSlot("10:00-11:00"));
		timeSlotList.add(new TimeSlot("11:00-12:00"));
		timeSlotList.add(new TimeSlot("12:00-13:00"));
		timeSlotList.add(new TimeSlot("13:00-14:00"));
		timeSlotList.add(new TimeSlot("14:00-15:00"));
		timeSlotList.add(new TimeSlot("15:00-16:00"));
		timeSlotList.add(new TimeSlot("16:00-17:00"));
		timeSlotList.add(new TimeSlot("18:00-18:00"));
		timeSlotList.add(new TimeSlot("19:00-20:00"));
	}

	public List<TimeSlot> getTimeSlotList() {
		return timeSlotList;
	}

	public void setTimeSlotList(List<TimeSlot> timeSlotList) {
		this.timeSlotList = timeSlotList;
	}
}
