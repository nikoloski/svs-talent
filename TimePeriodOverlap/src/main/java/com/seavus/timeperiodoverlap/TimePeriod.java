package com.seavus.timeperiodoverlap;

import java.time.LocalTime;

public class TimePeriod {

    private LocalTime startDate;
    private LocalTime endDate;

    public TimePeriod(LocalTime startDate, LocalTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }


    public boolean overlapsWith(TimePeriod timePeriod) {
        if (timePeriod == null || timePeriod.startDate == null || timePeriod.endDate == null) {
            throw new IllegalArgumentException();
        }

        if (startDate.isBefore(timePeriod.endDate) && (endDate.isAfter(timePeriod.startDate))) {
            return true;
        } else {
            return false;
        }
    }
}
