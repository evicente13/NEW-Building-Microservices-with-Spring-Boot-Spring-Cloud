package net.javaguides.departamentservice.mapper;

import net.javaguides.departamentservice.dto.DepartmentDto;
import net.javaguides.departamentservice.entity.Departament;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoDepartmentMapper {
    AutoDepartmentMapper MAPPER = Mappers.getMapper(AutoDepartmentMapper.class);

    DepartmentDto mapToDepartmentDto(Departament department);

    Departament mapToDepartment(DepartmentDto departmentDto);
}
