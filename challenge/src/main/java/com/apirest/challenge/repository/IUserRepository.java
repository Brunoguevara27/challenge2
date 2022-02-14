package com.apirest.challenge.repository;

import com.apirest.challenge.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<Usuario,Integer> {

    public Optional<Usuario> findByUsernameOrEmail(String username, String email);

    Usuario findByEmail(String email);

    Usuario findByUsername(String username);

    List<Usuario> findByRole(String role);

    List<Usuario> findAllByRole(String role);

}
