package com.xenosis.ems.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
public class EmployeeDto {

    private Integer id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @Past(message = "Date of birth must be a date in the past")
    @NotNull(message = "Date of birth cannot be null")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Department cannot be blank")
    @Size(min = 2, max = 50, message = "Department must be between 2 and 50 characters")
    private String department;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Salary cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Salary must be greater than zero")
    @Digits(integer = 10, fraction = 2, message = "Salary must be a valid number with two decimal places")
    private BigDecimal salary;

    @Min(value = 0, message = "Attendance must be at least 0")
    @Max(value = 31, message = "Attendance cannot exceed 31")
    private int attendance;
}
