package com.R.Rautomart.Service;

import com.R.Rautomart.DTO.EmployeeDTO;
import com.R.Rautomart.Entity.employee;
import com.R.Rautomart.Repo.EmployeeRepo;
import com.R.Rautomart.utill.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;
    public String saveEmployee(EmployeeDTO employeeDTO){
        if(employeeRepo.existsById(employeeDTO.getEmpId())){
            System.out.println("hellow");
            return VarList.RSP_DUPLICATED;
        }
        else{
            System.out.println("hehe");
            employeeRepo.save(modelMapper.map(employeeDTO, employee.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateEmployee(EmployeeDTO employeeDTO){
        if(employeeRepo.existsById(employeeDTO.getEmpId())){
            employeeRepo.save(modelMapper.map(employeeDTO,employee.class));
            return VarList.RSP_SUCCESS;
        }
        else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<EmployeeDTO> getAllEmployee(){
        List<employee> employeeList=employeeRepo.findAll();
        return modelMapper.map(employeeList,new TypeToken<ArrayList<EmployeeDTO>>(){
        }.getType());
    }
    public EmployeeDTO searchEmployee(int empId){
        if(employeeRepo.existsById( empId)){
            employee emp =employeeRepo.findById(empId).orElse(null);
            return modelMapper.map(emp,EmployeeDTO.class);
        }
        else{
            return null;
        }
    }

}
