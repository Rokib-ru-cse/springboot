package com.rokibrucse.exceptionvalidation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //user name should not be null or empty
    //user name should have at least 2 characters
    @NotEmpty
    @Size(min = 2, message = "user name should have at least 2 characters")
    @Column(unique = true)
    private String name;

    //email should be a valid email format
    //email should not be null or empty
    @NotEmpty
    @Email
    @Column(unique = true)
    private String email;

    //password should not be null or empty
    //password should have at least 8 characters
    @NotEmpty
    @Size(min = 8, message = "password should have at least 8 characters")
    private String password;
}
