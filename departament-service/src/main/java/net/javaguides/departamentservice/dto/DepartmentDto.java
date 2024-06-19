package net.javaguides.departamentservice.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private Long id;
    @NotEmpty(message = "Department name should not be null or empty")
    private String departamentName;
    @NotEmpty(message = "Department description should not be null or empty")
    private String departamentDescription;
    @NotEmpty(message = "Department code should not be null or empty")
    private String departamentCode;
}
