package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    @NotEmpty
    @Size(min = 1, message = "Username must be min 1 characters..!")
    private String firstName;

    @NotEmpty
    @Size(min = 3, message = "Lastname must be min 3 characters..!")
    private String lastName;

    @NotEmpty
    @Size(min = 10, max = 12, message = "Mobile Number must be min 10 numbers and max of 12 numbers !!")
    private String mobileNumber;

    @NotEmpty
    @Size(min = 3, max = 10, message = "Password must be min 3 chars and max of 10 chars !!")
    private String password;

    private boolean creatingStatus;
}
