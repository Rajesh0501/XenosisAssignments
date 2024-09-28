package com.xenosis.ems.Service;

import com.xenosis.ems.Repository.EmployeeReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeReportServiceImpl implements EmployeeReportService{
     @Autowired
     private EmployeeReportRepo employeeReportRepo;
    @Override
    public List<Object[]> getDepartmentWiseDistribution() {
        return employeeReportRepo.getDepartmentWiseDistribution();
    }

    @Override
    public List<Object[]> getEmployeeSalaryReport() {
        return employeeReportRepo.getEmployeeSalaryReport();
    }

    @Override
    public List<Object[]> getEmployeeAttendanceReport() {
        return employeeReportRepo.getEmployeeAttendanceReport();
    }
}
