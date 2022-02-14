package com.apirest.challenge.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@ToString
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    @Column(unique = true)
    private String email;

    @Getter @Setter
    private String firstName;

    @Getter @Setter
    private String lastName;

    @Getter @Setter
    private String password;

    @Getter @Setter
    private Date updated;

    @Getter @Setter
    private Date created;

    @Getter @Setter
    @Column(unique = true)
    private String username;

    @Getter @Setter
    @Column(length = 25)
    private String role;

    public Usuario() {
    }

    public Usuario(Integer id, String email, String firstName, String lastName, String password, Date updated, Date created, String username, String role) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.updated = updated;
        this.created = created;
        this.username = username;
        this.role = role;
    }

    public Usuario(String email, String firstName, String lastName, String password, Date updated, Date created, String username, String role) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.updated = updated;
        this.created = created;
        this.username = username;
        this.role = role;
    }
}
