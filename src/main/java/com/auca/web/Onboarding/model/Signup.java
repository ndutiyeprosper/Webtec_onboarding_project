package com.example.Onboarding.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Signup {
  @Id
  protected String password;
    protected String email;

    public Signup() {
    }

    public Signup(String password) {
        this.password = password;
    }

    public Signup(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
