package com.xenosis.ems.Controller;

import com.xenosis.ems.Service.EmployeeService;
import com.xenosis.ems.dto.EmployeeDto;
import com.xenosis.ems.dto.EmployeeResponsePagination;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save-employee")
    public ResponseEntity<?> saveEmployee(@RequestBody @Valid EmployeeDto employeeDto){
        try{
            Boolean saveEmployee  =  employeeService.saveEmployee(employeeDto);
            if (!saveEmployee){
                return new ResponseEntity<>("error while save employee",HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
         return new ResponseEntity<>("save Employee", HttpStatus.CREATED);
    }

    @GetMapping("/get-employee")
    public ResponseEntity<?> getEmployee(){
        List<EmployeeDto> employeeDtoList = null;
        try{
            employeeDtoList = employeeService.getAllEmployee();
            if (CollectionUtils.isEmpty(employeeDtoList)){
                return new ResponseEntity<>("error while get employee",HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(employeeDtoList, HttpStatus.OK);
    }

    @GetMapping("/get-employee/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") Integer id){
          EmployeeDto employeeDto = null;
        try{
            employeeDto = employeeService.getEmployeeById(id);
            if (ObjectUtils.isEmpty(employeeDto)){
                return new ResponseEntity<>("error while get employee By id" + id,HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(employeeDto, HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-employee/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") Integer id){
        Boolean deleteEmployee = null;
        try{
            deleteEmployee = employeeService.deleteEmployeeById(id);
            if (!deleteEmployee){
                return new ResponseEntity<>("error while delete employee By id" + id,HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("delete Success", HttpStatus.OK);
    }

    @PutMapping("/update-employee/{id}")
    public ResponseEntity<?> updateEmployeeById(@PathVariable("id") Integer id,@RequestBody EmployeeDto employeeDto){
        Boolean updateEmployee = null;
        try{
            updateEmployee = employeeService.updateEmployee(id,employeeDto);
            if (!updateEmployee){
                return new ResponseEntity<>("error while update employee By id" + id,HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("update Successfully", HttpStatus.OK);
    }

    @GetMapping("/get-employee-with-page")
    public ResponseEntity<?> getEmployee(@RequestParam(name = "pageNo") int pageNo, @RequestParam(name = "pageSize") int pageSize,
                                         @RequestParam(name="sortBy") String sortBy,@RequestParam(name = "sortDir") String sortDir) {
        EmployeeResponsePagination employeeResponsePagination = null;
        try{
            employeeResponsePagination = employeeService.getEmployeeWithPaginationAndSort(pageNo,pageSize,sortBy,sortDir);
            if (ObjectUtils.isEmpty(employeeResponsePagination)){
                return new ResponseEntity<>("error while get employee with pagination and sorting",HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(employeeResponsePagination, HttpStatus.OK);
    }


}
