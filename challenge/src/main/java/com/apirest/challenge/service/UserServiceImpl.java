package com.apirest.challenge.service;

import com.apirest.challenge.controller.ProductsController;
import com.apirest.challenge.dto.ProductsDto;
import com.apirest.challenge.dto.UsuarioDto;
import com.apirest.challenge.model.Products;
import com.apirest.challenge.model.Usuario;
import com.apirest.challenge.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        Usuario user = userRepository.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail).orElseThrow(()->new UsernameNotFoundException("Usuario no encontrado con ese username o email: "+usernameOrEmail));
        logger.info("User para acceder: {}",user);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+user.getRole()));

        User userDetails = new User(user.getEmail(),user.getPassword(),authorities);
        return userDetails;

    }

    public List<GrantedAuthority> buildgrante(String rol){
        String[] roles = {"ADMIN"};
        List<GrantedAuthority> auths = new ArrayList<>();
        for(int i = 0; i<roles.length; i++) {
            auths.add(new SimpleGrantedAuthority(roles[i]));
        }
        return auths;
    }

    // Convierte entidad a DTO
    private UsuarioDto mapearDTO(Usuario usuario) {
        UsuarioDto usuarioDto = modelMapper.map(usuario, UsuarioDto.class);
        return usuarioDto;
    }

    // Convierte de DTO a Entidad
    private Usuario mapearEntidad(UsuarioDto usuarioDto) {
        Usuario usuario = modelMapper.map(usuarioDto, Usuario.class);
        return usuario;
    }
}
