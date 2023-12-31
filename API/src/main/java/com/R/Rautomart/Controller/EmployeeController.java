package com.R.Rautomart.Controller;

import com.R.Rautomart.DTO.EmployeeDTO;
import com.R.Rautomart.DTO.ResponseDTO;
import com.R.Rautomart.Entity.employee;
import com.R.Rautomart.Repo.EmployeeRepo;
import com.R.Rautomart.Service.EmployeeService;
import com.R.Rautomart.utill.VarList;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ResponseDTO responseDTO;
    @PostMapping(value="/saveEmployee")
    public ResponseEntity saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        System.out.println(employeeDTO.getContactNo());
        try{
            String res= employeeService.saveEmployee(employeeDTO);
            if(res.equals("000")){
                responseDTO.setCode(VarList.RSP_DUPLICATED );
                responseDTO.setMessage("Success");
                responseDTO.setContent(employeeDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(res.equals("006")){
                responseDTO.setCode(VarList.RSP_DUPLICATED );
                responseDTO.setMessage("Employee registered");
                responseDTO.setContent(employeeDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }else{
                responseDTO.setCode(VarList.RSP_FAIL );
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }
        }catch( Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR );
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value="/updateEmployee")
    public ResponseEntity updateEmployee(@RequestBody EmployeeDTO employeeDTO){
        System.out.println(employeeDTO.getContactNo());
        try{
            String res= employeeService.updateEmployee(employeeDTO);
            if(res.equals("000")){
                responseDTO.setCode(VarList.RSP_DUPLICATED );
                responseDTO.setMessage("Success");
                responseDTO.setContent(employeeDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(res.equals("001")){
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND );
                responseDTO.setMessage("Not a Registered member ");
                responseDTO.setContent(employeeDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }else{
                responseDTO.setCode(VarList.RSP_FAIL );
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }
        }catch( Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR );
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllEmployee")

    public ResponseEntity getAllEmployees(){
        try{
           List<EmployeeDTO>  emp=employeeService.getAllEmployee();
            responseDTO.setCode(VarList.RSP_DUPLICATED );
            responseDTO.setMessage("Success");
            responseDTO.setContent(emp);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

        }catch(Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent((null));
            return new ResponseEntity(responseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/searchEmployee/{empID}")
    public ResponseEntity searchEmployee(@PathVariable int empID){
        try{
            EmployeeDTO empDTO= employeeService.searchEmployee(empID);
            if(empDTO !=null){
                responseDTO.setCode(VarList.RSP_DUPLICATED );
                responseDTO.setMessage("Success");
                responseDTO.setContent(empDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }
            else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No employee found ");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }}catch( Exception e){
                responseDTO.setCode(VarList.RSP_ERROR );
                responseDTO.setMessage(e.getMessage());
                responseDTO.setContent(e);
                return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }


    @DeleteMapping("/deleteEmployee/{empID}")
    public ResponseEntity deleteEmployee(@PathVariable int empID){
        try{
            String emp= employeeService.deleteEmployee(empID);
            if(emp.equals("000")){
                responseDTO.setCode(VarList.RSP_DUPLICATED );
                responseDTO.setMessage("Success");
                responseDTO.setContent(emp);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }
            else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No employee found ");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }}catch( Exception e){
            responseDTO.setCode(VarList.RSP_ERROR );
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(e);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
