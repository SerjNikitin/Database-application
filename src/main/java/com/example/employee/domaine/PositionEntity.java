package com.example.employee.domaine;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "position")
@ToString(exclude = {"employees", "id"})
@EqualsAndHashCode(exclude = {"id", "employees"})
public class PositionEntity {
    @Id
    @Column(name = "position_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "salary")
    private Integer salary;

    @OneToMany(mappedBy = "position", fetch = FetchType.LAZY)
    private List<EmployeeEntity> employees;
}