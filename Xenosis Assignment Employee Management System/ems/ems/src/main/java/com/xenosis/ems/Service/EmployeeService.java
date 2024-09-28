package com.xenosis.ems.Service;

import com.xenosis.ems.Model.Employee;
import com.xenosis.ems.dto.EmployeeDto;
import com.xenosis.ems.dto.EmployeeResponsePagination;

import java.util.List;

public interface EmployeeService {

    public Boolean saveEmployee(EmployeeDto employeeDto);
    public List<EmployeeDto> getAllEmployee();
    public EmployeeDto getEmployeeById(Integer id);
    public Boolean deleteEmployeeById(Integer id);
    public Boolean updateEmployee(Integer id,EmployeeDto employeeDto);
    public EmployeeResponsePagination getEmployeeWithPaginationAndSort(int pageNo, int pageSIze, String sortBy, String sortDir);
}
