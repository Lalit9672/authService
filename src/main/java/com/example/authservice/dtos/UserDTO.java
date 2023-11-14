package com.example.authservice.dtos;

import com.example.authservice.models.Session;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private String fullName;;
    private String email;
    private String token;
}
