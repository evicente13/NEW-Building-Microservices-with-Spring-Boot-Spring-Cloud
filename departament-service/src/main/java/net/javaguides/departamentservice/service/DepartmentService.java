package net.javaguides.departamentservice.service;

import net.javaguides.departamentservice.dto.DepartmentDto;

public interface DepartmentService {

    DepartmentDto save(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code);

}
