package com.apirest.challenge.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class UsuarioDto {

    @Getter @Setter
    private Integer id;

    @Getter @Setter
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
    private String username;

    @Getter @Setter
    private String role;

    public UsuarioDto() {
    }

    public UsuarioDto(Integer id, String email, String firstName, String lastName, String password, Date updated, Date created, String username, String role) {
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
}
