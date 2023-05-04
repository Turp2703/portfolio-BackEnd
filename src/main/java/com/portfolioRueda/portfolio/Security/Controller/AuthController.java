package com.portfolioRueda.portfolio.Security.Controller;

import com.portfolioRueda.portfolio.Security.Dto.JwtDto;
import com.portfolioRueda.portfolio.Security.Dto.LogInUser;
import com.portfolioRueda.portfolio.Security.Dto.NewUser;
import com.portfolioRueda.portfolio.Security.Entity.Role;
import com.portfolioRueda.portfolio.Security.Entity.User;
import com.portfolioRueda.portfolio.Security.Enums.RoleName;
import com.portfolioRueda.portfolio.Security.Service.RoleService;
import com.portfolioRueda.portfolio.Security.Service.UserService;
import com.portfolioRueda.portfolio.Security.jwt.JwtProvider;
import jakarta.validation.Valid;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
//Local
//@CrossOrigin(origins = "http://localhost:4200")
//Deploy
@CrossOrigin(origins = "https://rueda-portfolio-frontend.web.app/")
public class AuthController {
    @Autowired PasswordEncoder passwordEncoder;
    @Autowired AuthenticationManager authenticationManager;
    @Autowired UserService userService;
    @Autowired RoleService roleService;
    @Autowired JwtProvider jwtProvider;
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody NewUser newUser, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(new msg("Wrong fields"),HttpStatus.BAD_REQUEST);
        }
        if(userService.existsByUserName(newUser.getUserName())){
            return new ResponseEntity(new msg("Username already exists"),HttpStatus.BAD_REQUEST);
        }
        
        User user = new User(newUser.getName(), newUser.getUserName(),
                passwordEncoder.encode(newUser.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getByRoleName(RoleName.ROLE_USER).get());
        
        if(newUser.getRoles().contains("admin")){
            roles.add(roleService.getByRoleName(RoleName.ROLE_ADMIN).get());
        }
        
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity(new msg("User Created"),HttpStatus.CREATED);
    }
    
    @PostMapping("/logIn")
    public ResponseEntity<JwtDto> logIn(@Valid @RequestBody LogInUser logInUser, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(new msg("Wrong fields"),HttpStatus.BAD_REQUEST);
        }
        
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
        logInUser.getUserName(), logInUser.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
