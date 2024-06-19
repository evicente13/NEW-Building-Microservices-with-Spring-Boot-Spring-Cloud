package net.javaguides.departamentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "departments")
public class Departament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "departament_name", nullable = false)
    private String departamentName;
    @Column(name = "departament_description", nullable = false)
    private String departamentDescription;
    @Column(name = "departament_code", nullable = false)
    private String departamentCode;

}
