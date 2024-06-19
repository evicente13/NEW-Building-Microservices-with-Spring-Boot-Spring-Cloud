package net.javaguides.departamentservice.repository;


import net.javaguides.departamentservice.entity.Departament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Departament, Long> {
    Departament findByDepartamentCode(String departmentCode);
}
