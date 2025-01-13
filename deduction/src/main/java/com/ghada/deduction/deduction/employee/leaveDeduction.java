package com.ghada.deduction.deduction.employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class leaveDeduction {
    private Integer id;
    private Double leavededuction;
}
