package com.cdsoftware.hireme.auth;

import com.cdsoftware.hireme.enums.Roles;
import com.cdsoftware.hireme.enums.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequest {

    @NotNull(message = "Name cant be empty")
    @NotEmpty(message = "Name cant be empty")
    private String firstname;
    private String lastname;

    @Email(message = "Must provide a Valid email")
    @NotNull(message = "Email cant be null")
    @NotEmpty(message = "Email cant be null")
    private String email;

    @NotNull
    @NotEmpty
    private String password;
    private Roles roles;
    private UserType userType;
}
