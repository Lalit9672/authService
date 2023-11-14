package com.example.authservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseModel {
      private String email;
      private String password;
      private String fullName;
      @OneToMany(mappedBy = "user")
      private List<Session> session;
}
