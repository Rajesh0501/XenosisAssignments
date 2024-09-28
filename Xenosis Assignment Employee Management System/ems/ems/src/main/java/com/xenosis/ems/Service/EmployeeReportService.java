package com.xenosis.ems.Service;


import java.util.List;

public interface EmployeeReportService {

    public List<Object[]> getDepartmentWiseDistribution();

    public List<Object[]> getEmployeeSalaryReport();

    public List<Object[]> getEmployeeAttendanceReport();

}
