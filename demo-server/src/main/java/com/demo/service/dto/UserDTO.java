package com.demo.service.dto;

public class UserDTO {

    private int uniqueId;
    private String userId;
    private String name;
    private String password;
    private String gender;

    // Default constructor
    public UserDTO() {}

    // Parameterized constructor
    public UserDTO(int uniqueId, String userId, String name, String password, String gender) {
        this.uniqueId = uniqueId;
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.gender = gender;
    }

    // Getters and Setters
    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "UserDTO{" +
                "uniqueId=" + uniqueId +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
