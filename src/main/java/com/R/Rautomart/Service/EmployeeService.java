package com.R.Rautomart.Service;

import com.R.Rautomart.DTO.EmployeeDTO;
import com.R.Rautomart.Entity.employee;
import com.R.Rautomart.Repo.EmployeeRepo;
import com.R.Rautomart.utill.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;
    public String saveEmployee(EmployeeDTO employeeDTO){
        if(employeeRepo.existsById(employeeDTO.getEmpId())){
            return VarList.RSP_DUPLICATED;
        }
        else{
            employeeRepo.save(modelMapper.map(employeeDTO, employee.class));
            return VarList.RSP_SUCCESS;
        }
    }

}
