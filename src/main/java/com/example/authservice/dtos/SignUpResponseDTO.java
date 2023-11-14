package com.example.authservice.dtos;


import com.example.authservice.models.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SignUpResponseDTO extends BaseResponseDTO{
    private UserDTO user;
}
