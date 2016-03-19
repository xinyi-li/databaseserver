package com.madadata.testjdbi;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

/**
 * Created by lixinyi on 16/3/19.
 */
public class UserProfile {

    @Length(min = 3)
    private String firstName;
    @Length(min = 3)
    private String lastName;
    @Email
    private String email;
    @Range(min = 0)
    private int age;

    public UserProfile() {
    }

    public UserProfile(String firstName, String lastName, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    @JsonProperty
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty
    public String getLastName() {
        return lastName;
    }

    @JsonProperty
    public String getEmail() {
        return email;
    }

    @JsonProperty
    public int getAge() {
        return age;
    }

}
