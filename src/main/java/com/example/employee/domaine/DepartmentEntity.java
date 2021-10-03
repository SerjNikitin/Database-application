package com.example.employee.domaine;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "department")
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"employee", "depId", "employeeList"})
@EqualsAndHashCode(exclude = {"depId", "employee", "employeeList"})
public class DepartmentEntity {

    @Id
    @Column(name = "dep_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long depId;

    @Column(name = "name")
    private String depName;

    @Column(name = "phone")
    private Integer phone;

    @Column(name = "email")
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "department_manager",
            joinColumns = @JoinColumn(name = "dep_id"),
            inverseJoinColumns = @JoinColumn(name = "emp_id")
    )
    private EmployeeEntity employee;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<EmployeeEntity> employeeList;

}
