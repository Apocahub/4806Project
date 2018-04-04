package sysc4806.pm4y.models.schedule;

import java.util.ArrayList;
import java.util.List;

public enum Days {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday")
    ;
    private String value;
    private TimeRange t0 = new TimeRange("08:00-09:00");
    private TimeRange t1 = new TimeRange("09:00-10:00");
    private TimeRange t2 = new TimeRange("10:00-11:00");
    private TimeRange t3 = new TimeRange("11:00-12:00");
    private TimeRange t4 = new TimeRange("12:00-13:00");
    private TimeRange t5 = new TimeRange("13:00-14:00");
    private TimeRange t6 = new TimeRange("14:00-15:00");
    private TimeRange t7 = new TimeRange("15:00-16:00");
    private TimeRange t8 = new TimeRange("16:00-17:00");
    private TimeRange t9 = new TimeRange("17:00-18:00");
    private TimeRange t10 = new TimeRange("18:00-19:00");
    private TimeRange t11 = new TimeRange("19:00-20:00");
    Days(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public TimeRange getT0() {
        return t0;
    }

    public TimeRange getT1() {
        return t1;
    }

    public TimeRange getT2() {
        return t2;
    }

    public TimeRange getT3() {
        return t3;
    }

    public TimeRange getT4() {
        return t4;
    }

    public TimeRange getT5() {
        return t5;
    }

    public TimeRange getT6() {
        return t6;
    }

    public TimeRange getT7() {
        return t7;
    }

    public TimeRange getT8() {
        return t8;
    }

    public TimeRange getT9() {
        return t9;
    }

    public TimeRange getT10() {
        return t10;
    }

    public TimeRange getT11() {
        return t11;
    }
}
