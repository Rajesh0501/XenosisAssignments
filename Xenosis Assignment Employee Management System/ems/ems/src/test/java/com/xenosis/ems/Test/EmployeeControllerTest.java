package com.xenosis.ems.Test;

import com.xenosis.ems.Controller.EmployeeController;
import com.xenosis.ems.Service.EmployeeService;
import com.xenosis.ems.dto.EmployeeDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EmployeeControllerTest {
    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveEmployee_Success() {
        EmployeeDto employeeDto = createEmployeeDto();
        when(employeeService.saveEmployee(employeeDto)).thenReturn(true);

        ResponseEntity<?> response = employeeController.saveEmployee(employeeDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("save Employee", response.getBody());
        verify(employeeService, times(1)).saveEmployee(employeeDto);
    }

    @Test
    public void testSaveEmployee_Failure() {
        EmployeeDto employeeDto = createEmployeeDto();
        when(employeeService.saveEmployee(employeeDto)).thenReturn(false);

        ResponseEntity<?> response = employeeController.saveEmployee(employeeDto);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("error while save employee", response.getBody());
        verify(employeeService, times(1)).saveEmployee(employeeDto);
    }

    @Test
    public void testGetEmployee_Success() {
        List<EmployeeDto> employeeList = new ArrayList<>();
        employeeList.add(createEmployeeDto());
        when(employeeService.getAllEmployee()).thenReturn(employeeList);

        ResponseEntity<?> response = employeeController.getEmployee();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employeeList, response.getBody());
        verify(employeeService, times(1)).getAllEmployee();
    }

    @Test
    public void testGetEmployee_Failure() {
        when(employeeService.getAllEmployee()).thenReturn(new ArrayList<>());

        ResponseEntity<?> response = employeeController.getEmployee();

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("error while get employee", response.getBody());
        verify(employeeService, times(1)).getAllEmployee();
    }

    @Test
    public void testGetEmployeeById_Success() {
        EmployeeDto employeeDto = createEmployeeDto();
        when(employeeService.getEmployeeById(1)).thenReturn(employeeDto);

        ResponseEntity<?> response = employeeController.getEmployeeById(1);

        assertEquals(HttpStatus.FOUND, response.getStatusCode());
        assertEquals(employeeDto, response.getBody());
        verify(employeeService, times(1)).getEmployeeById(1);
    }

    @Test
    public void testGetEmployeeById_Failure() {
        when(employeeService.getEmployeeById(1)).thenReturn(null);

        ResponseEntity<?> response = employeeController.getEmployeeById(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("error while get employee By id1", response.getBody());
        verify(employeeService, times(1)).getEmployeeById(1);
    }

    @Test
    public void testDeleteEmployeeById_Success() {
        when(employeeService.deleteEmployeeById(1)).thenReturn(true);

        ResponseEntity<?> response = employeeController.deleteEmployeeById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("delete Success", response.getBody());
        verify(employeeService, times(1)).deleteEmployeeById(1);
    }

    @Test
    public void testDeleteEmployeeById_Failure() {
        when(employeeService.deleteEmployeeById(1)).thenReturn(false);

        ResponseEntity<?> response = employeeController.deleteEmployeeById(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("error while delete employee By id1", response.getBody());
        verify(employeeService, times(1)).deleteEmployeeById(1);
    }

    // Helper method to create a sample EmployeeDto
    private EmployeeDto createEmployeeDto() {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        employeeDto.setName("John Doe");
        employeeDto.setDateOfBirth(LocalDate.of(1990, 5, 20));
        employeeDto.setDepartment("Engineering");
        employeeDto.setEmail("john.doe@example.com");
        employeeDto.setSalary(BigDecimal.valueOf(50000));
        employeeDto.setAttendance(25);
        return employeeDto;
    }
}
