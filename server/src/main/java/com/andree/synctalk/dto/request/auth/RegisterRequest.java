package com.andree.synctalk.dto.request.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {



    @NotBlank(message = "First name must not be blank")
    private String firstName;

    @NotBlank(message = "Last name must not be blank")
    private String lastName;

    @NotBlank(message = "Username must not be blank")
    @Size(min = 4, max = 40)
    private String username;

    @Email(message = "Email is not valid")
    @NotBlank(message = "Email must not be blank")
    private String email;

    @NotBlank(message = "Phone must not be blank")
    @Size(min = 4, max = 15)
    private String phone;

    @JsonProperty("password")
    @NotBlank(message = "Password must not be blank")
    private String passwordHash;

    private String biography;
}
