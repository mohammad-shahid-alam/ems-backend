package net.javaguides.ems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parking_spot")
public class ParkingSpot extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String spotNumber;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;



}
