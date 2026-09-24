package net.javaguides.ems.dto;


import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeDto {

    private  Long id;

    @NotBlank(message = "First name is required")
    @Size(max = 50 , message = "First name must not exceed 50 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 50 , message = "Last name must not exceed 50 characters")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Put the valid email")
    private String email;

    @Pattern(regexp = "^[0-9]{10}$" , message = "Phone number must be exactly 10 digits ")
    private String phoneNumber;

    @Positive(message = "Salary must be greater than zero")
    private Double salary;

    @PastOrPresent(message = "Date of joining cannot be in the future")
    private LocalDate dateOfJoining;



}
