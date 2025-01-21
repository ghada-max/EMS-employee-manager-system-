package com.ghada.attendanceproject.attendance;



import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@Data
@Builder
@Table(name="attendance_tab")
public class attendance {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer userid;//selected
    private Integer employeeid;//selected
    private LocalDateTime date;//mark date now
   // @NotEmpty(message="InDate unmarked")
    private LocalDateTime clockInTime;//mark timenow
    private LocalDateTime openinghour;
    private LocalDateTime closinghour;

    //  @NotEmpty(message="OutDate unmarked")
    private LocalDateTime clockOutTime;//mark timenow
    private String markedBy; //user.admin name
    private LocalDateTime markedAt; //now
    @Enumerated(EnumType.STRING)
    private attendancetatus attendancestatus;
}
