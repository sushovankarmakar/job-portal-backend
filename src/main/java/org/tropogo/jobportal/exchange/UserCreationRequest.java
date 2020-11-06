package org.tropogo.jobportal.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserCreationRequest {

    @JsonProperty("name")
    @NotBlank(message = "name field is missing")
    private String name;

    @JsonProperty("email")
    @NotBlank(message = "email field is missing")
    @Email(message = "please, provide a valid email")
    private String email;

    @JsonProperty("gender")
    @NotBlank(message = "gender field is missing")
    private String gender;
}