package com.mattpus.surveyrestapi.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserDetails {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String role;

    public UserDetails(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public UserDetails() {

    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
