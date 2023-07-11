package com.R.Rautomart.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Employee")
public class employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // for generate Id
    private int empId;
    private String name;
    private String contactNo;
    private int acNo;
}
