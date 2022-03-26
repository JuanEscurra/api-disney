package com.challenge.apidisney.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserDTO {

    @Email(message = "{email.not.valid}")
    @NotEmpty(message = "{email.not.empty}")
    private String email;

    @Size(min = 6, message = "{password.not-size.valid}")
    @NotEmpty(message = "{password.not.empty}")
    private String password;

    public UserDTO() {
    }

    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
