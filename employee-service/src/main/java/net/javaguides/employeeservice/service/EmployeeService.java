package net.javaguides.employeeservice.service;

import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);
}
