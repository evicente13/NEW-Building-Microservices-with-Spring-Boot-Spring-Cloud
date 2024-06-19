package net.javaguides.employeeservice.dto;

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
    private String departamentName;
    private String departamentDescription;
    private String departamentCode;

    @Override
    public String toString() {
        return "DepartmentDto{" +
                "id=" + id +
                ", departamentName='" + departamentName + '\'' +
                ", departamentDescription='" + departamentDescription + '\'' +
                ", departamentCode='" + departamentCode + '\'' +
                '}';
    }
}
