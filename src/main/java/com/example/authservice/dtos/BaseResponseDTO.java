package com.example.authservice.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponseDTO {
    private boolean success;
    private String error;
}
