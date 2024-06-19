package net.javaguides.employeeservice.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;
    @NotEmpty(message = "Employee first name should not be null or empty")
    private String firstName;
    @NotEmpty(message = "Employee last name should not be null or empty")
    private String lastName;
    @NotEmpty(message = "Employee email should not be null or empty")
    private String email;
}
