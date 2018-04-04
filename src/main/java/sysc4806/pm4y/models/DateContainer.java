package sysc4806.pm4y.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class DateContainer {

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateTime;

    public DateContainer() {
        dateTime = LocalDateTime.now();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

}