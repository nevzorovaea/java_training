package ru.stqa.pft.mantis.model;

public class UserData {

  private String username;
  private String password;
  private String email;

  public String getEmail() {
    return email;
  }

  public UserData setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public UserData setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public UserData setPassword(String password) {
    this.password = password;
    return this;
  }


}