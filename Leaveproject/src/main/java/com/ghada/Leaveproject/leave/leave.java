package com.ghada.Leaveproject.leave;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import java.util.Date;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@Data
@Builder
@Table(name="leave_tab")
public class leave {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer emloyeeid;
    private Date startDay;
    private Date endDay;
    private Integer numberOfDay;
    @NotEmpty(message = "Details field is empty")
    private String details;

    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;  // Enum should be defined to specify leave types


}
