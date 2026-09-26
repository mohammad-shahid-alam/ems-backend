package net.javaguides.ems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column(name = "first_name")
     private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Double salary;
    private LocalDate dateOfJoining;


    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;


}
