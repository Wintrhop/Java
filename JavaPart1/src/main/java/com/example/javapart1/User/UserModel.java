package com.example.javapart1.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Collection;
import java.util.Collections;

@Document(collection = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel implements UserDetails {

    @Id
    private String id;
    private String username;
    private String password;
    private String email;
    private String identification;
    private String address;
    private String cellphone;
    private String org;
    private String type;
    @Enumerated(EnumType.STRING)
    private UserRoles userRoles;
    private Boolean locked;
    private Boolean enabled;

    public UserModel(String username, String password, String email, UserRoles userRoles) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.identification = identification;
        this.address = address;
        this.cellphone = cellphone;
        this.org = org;
        this.type = type;
        this.userRoles = userRoles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRoles.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
