package net.javaguides.departamentservice.controller;

import jakarta.validation.Valid;
import net.javaguides.departamentservice.dto.DepartmentDto;
import net.javaguides.departamentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> savedDepartment(@Valid @RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDepartment = departmentService.save(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/{deparment-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("deparment-code") String code) {
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(code);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);

    }
}
