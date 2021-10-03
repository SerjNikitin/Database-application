package com.example.employee.domaine;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"position","empId","department"})
@EqualsAndHashCode(exclude = {"empId", "position","department"})
public class EmployeeEntity {

    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    @Column(name = "date_birth_day")
    private LocalDate birthDay;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "gender")
    private String gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "employee_position",
            joinColumns = @JoinColumn(name = "emp_id"),
            inverseJoinColumns = @JoinColumn(name = "position_id")
    )
    private PositionEntity position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "employee_department",
            joinColumns = @JoinColumn(name = "emp_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    private DepartmentEntity department;
}
