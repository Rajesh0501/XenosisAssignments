package com.xenosis.ems.Controller;

import com.xenosis.ems.Service.EmployeeReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/report")
public class EmployeeReportController {

    @Autowired
    private EmployeeReportService employeeReportService;

    @GetMapping("/department-distribution")
    public ResponseEntity<List<Object[]>> getDepartmentWiseDistribution() {
        List<Object[]> report = employeeReportService.getDepartmentWiseDistribution();
        return ResponseEntity.ok(report);
    }

    @GetMapping("/salary-report")
    public ResponseEntity<List<Object[]>> getEmployeeSalaryReport() {
        List<Object[]> report = employeeReportService.getEmployeeSalaryReport();
        return ResponseEntity.ok(report);
    }

    @GetMapping("/attendance-report")
    public ResponseEntity<List<Object[]>> getEmployeeAttendanceReport() {
        List<Object[]> report = employeeReportService.getEmployeeAttendanceReport();
        return ResponseEntity.ok(report);
    }
}
