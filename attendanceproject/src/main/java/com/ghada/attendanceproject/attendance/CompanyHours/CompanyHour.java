package com.ghada.attendanceproject.attendance.CompanyHours;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
@Data
@Component
public class CompanyHour {
    public final LocalTime openingHour=LocalTime.of(9,0);
    public final LocalTime closingHour=LocalTime.of(17,0);
    public final Integer workHour=8;

}
