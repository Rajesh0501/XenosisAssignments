package com.xenosis.ems.Repository;


import com.xenosis.ems.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeReportRepo extends JpaRepository<Employee,Integer> {

    @Query("SELECT e.department, COUNT(e.id) FROM Employee e GROUP BY e.department")
    List<Object[]> getDepartmentWiseDistribution();

    @Query("SELECT e.name, e.salary FROM Employee e")
    List<Object[]> getEmployeeSalaryReport();

    @Query("SELECT e.name, e.attendance FROM Employee e")
    List<Object[]> getEmployeeAttendanceReport();
}
