package com.portfolioRueda.portfolio.Security.Entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MainUser implements UserDetails{
    private String name;
    private String userName;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public MainUser(String name, String userName, String password, Collection<? extends GrantedAuthority> authorities) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.authorities = authorities;
    }
    
    public static MainUser build(User user){
        List<GrantedAuthority> authority = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName().name())).collect(Collectors.toList());
        return new MainUser(user.getName(), user.getUserName(), user.getPassword(), authority);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    
    public String getName() {
        return name;
    }

    @Override
    public String getUsername() {
        return userName;
    }
    
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
