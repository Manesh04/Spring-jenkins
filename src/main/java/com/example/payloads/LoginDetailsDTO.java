package com.example.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class LoginDetailsDTO {

    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String password;
    private boolean creatingStatus;
}
