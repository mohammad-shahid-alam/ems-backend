package net.javaguides.ems.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeDto {

    private  Long id;

    @NotBlank(message = "First name is required")
    @Size(max = 50 , message = "First name must not exceed 50 characters")
    private String firstName;

    @NotBlank(message = "First name is required")
    @Size(max = 50 , message = "First name must not exceed 50 characters")
    private String lastName;

    @NotBlank(message = "Message is required")
    @Email(message = "Put the valid email")
    private String email;

}
