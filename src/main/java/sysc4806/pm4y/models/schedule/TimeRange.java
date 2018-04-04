package sysc4806.pm4y.models.schedule;

public class TimeRange {
    private String range;
    private String checked;

    public TimeRange(String range) {
        this.range = range;
        this.checked = String.valueOf(false);
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }
}
