package com.example.demo.auth.dto;

import jakarta.validation.constraints.*;

public class RegisterRequest {
  @Email @NotBlank
  private String email;

  @NotBlank @Size(min=6, max=72)
  private String password;

  @NotBlank @Size(max=50)
  private String displayName;

  @NotBlank @Size(max=80)
  private String city;

  private Short birthYear; // optional

  // getters/setters
  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }
  public String getPassword() { return password; }
  public void setPassword(String password) { this.password = password; }
  public String getDisplayName() { return displayName; }
  public void setDisplayName(String displayName) { this.displayName = displayName; }
  public String getCity() { return city; }
  public void setCity(String city) { this.city = city; }
  public Short getBirthYear() { return birthYear; }
  public void setBirthYear(Short birthYear) { this.birthYear = birthYear; }
}

