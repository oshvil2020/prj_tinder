package com.example.demo.profile;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "profile")
public class Profile {

  @Id
  @Column(name = "user_id")
  private Long userId; 

  @Column(name = "display_name", nullable = false)
  private String displayName;

  @Column(nullable = false)
  private String city;

  @Column(length = 280)
  private String bio;

  @Column(name = "birth_year")
  private Short birthYear;


  @Column(name = "created_at")
  private OffsetDateTime createdAt;

  @Column(name = "updated_at")
  private OffsetDateTime updatedAt;

  // getters/setters
  public Long getUserId() { return userId; }
  public void setUserId(Long userId) { this.userId = userId; }
  public String getDisplayName() { return displayName; }
  public void setDisplayName(String displayName) { this.displayName = displayName; }
  public String getCity() { return city; }
  public void setCity(String city) { this.city = city; }
  public String getBio() { return bio; }
  public void setBio(String bio) { this.bio = bio; }
  public Short getBirthYear() { return birthYear; }
  public void setBirthYear(Short birthYear) { this.birthYear = birthYear; }
  public OffsetDateTime getCreatedAt() { return createdAt; }
  public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }
  public OffsetDateTime getUpdatedAt() { return updatedAt; }
  public void setUpdatedAt(OffsetDateTime updatedAt) { this.updatedAt = updatedAt; }
}

