package com.R.Rautomart.Service;

import com.R.Rautomart.DTO.EmployeeDTO;
import com.R.Rautomart.Repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public String saveEmployee(EmployeeDTO employeeDTO){
        if(employeeRepo.existsById(employeeDTO.getEmpId())){

        }
        else{

        }
    }

}
