package com.xenosis.ems.Service;

import com.xenosis.ems.Config.ProjectConfig;
import com.xenosis.ems.Model.Employee;
import com.xenosis.ems.Repository.EmployeeRepo;
import com.xenosis.ems.dto.EmployeeDto;
import com.xenosis.ems.dto.EmployeeResponsePagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ProjectConfig projectConfig;
    @Override
    public Boolean saveEmployee(EmployeeDto employeeDto) {
 //       Employee employee = new Employee();
//        employee.setId(employeeDto.getId());
//        employee.setName(employeeDto.getName());
//        employee.setDateOfBirth(employeeDto.getDateOfBirth());
//        employee.setDepartment(employeeDto.getDepartment());
//        Employee save = employeeRepo.save(employee);
        Employee employee1 = projectConfig.modelMapper().map(employeeDto,Employee.class);
        Employee save =   employeeRepo.save(employee1);
        if (ObjectUtils.isEmpty(save)){
            return false;
        }
        return true;
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
      List<Employee> employees  = employeeRepo.findAll();
      List<EmployeeDto> employeeDtoList =  employees.stream().map(employee -> projectConfig.modelMapper()
              .map(employee,EmployeeDto.class))
              .collect(Collectors.toList());

        return employeeDtoList;
    }

    @Override
    public EmployeeDto getEmployeeById(Integer id) {
        Optional<Employee> employeeId =  employeeRepo.findById(id);
        if (employeeId.isPresent()){
            Employee employee = employeeId.get();
            EmployeeDto employeeDto = projectConfig.modelMapper().map(employee,EmployeeDto.class);
            return employeeDto;
        }
        return null;
    }

    @Override
    public Boolean deleteEmployeeById(Integer id) {
        Optional<Employee> employeeId =  employeeRepo.findById(id);
        if (employeeId.isPresent()){
            Employee employee = employeeId.get();
            employeeRepo.delete(employee);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateEmployee(Integer id, EmployeeDto employeeDto) {
        Optional<Employee> employeeId =  employeeRepo.findById(id);
        if (employeeId.isPresent()){
            Employee employee = employeeId.get();
            employee.setName(employeeDto.getName());
            employee.setDateOfBirth(employeeDto.getDateOfBirth());
            employee.setDepartment(employeeDto.getDepartment());
            employeeRepo.save(employee);
            return true;
        }
        return false;
    }

    @Override
    public EmployeeResponsePagination getEmployeeWithPaginationAndSort(int pageNo, int pageSIze, String sortBy, String sortDir) {

        Sort sortAsc =  Sort.by(sortBy).ascending();
        Sort sortDcs = Sort.by(sortBy).descending();

        Sort sort  = sortDir.equalsIgnoreCase("asc") ? sortAsc : sortDcs;

        Pageable pageable = PageRequest.of(pageNo, pageSIze,sort);
        Page<Employee> employees = employeeRepo.findAll(pageable);

        //employee class to employee employeeDto class
        List<Employee> content = employees.getContent();
        List<EmployeeDto> listEmployeeDto = content.stream().
                map(employee -> projectConfig.modelMapper().
                        map(employee, EmployeeDto.class)).toList();

        long totalElements = employees.getTotalElements();
        int totalPages = employees.getTotalPages();
        boolean first = employees.isFirst();
        boolean last = employees.isLast();
        //avoid this
//        EmployeeResponsePagination employeeResponsePagination = new EmployeeResponsePagination();
//        employeeResponsePagination.setTotalElements(totalElements);
        //using builder concept
       EmployeeResponsePagination employeeResponsePagination =  EmployeeResponsePagination.builder().employeeDtoList(listEmployeeDto).
                totalElements(totalElements).
                totalPages(totalPages).pageNo(pageNo).
                pageSize(pageSIze).
                first(first).
                last(last).build();

     return employeeResponsePagination;
    }
}
