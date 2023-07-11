package com.R.Rautomart.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
    private int empId;
    private String name;
    private String contactNo;
    private int acNo;
}
