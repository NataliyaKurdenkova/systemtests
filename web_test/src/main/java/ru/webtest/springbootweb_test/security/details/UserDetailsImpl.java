package ru.webtest.springbootweb_test.security.details;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.webtest.springbootweb_test.entitys.Role;
import ru.webtest.springbootweb_test.entitys.User;


import java.util.*;

import static org.apache.catalina.realm.UserDatabaseRealm.getRoles;


public class UserDetailsImpl implements UserDetails {

    private User user;
    private Collection<Role> roles;
    public UserDetailsImpl(User user) {
        this.user = user;
    }

  @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        //return Collections.singletonList(new SimpleGrantedAuthority(user.getRoles().toString()));
      return  getRoles();
    }

    private Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
    @Override
    public String getPassword() {
        return user.getHashPassword();
    }

    @Override
    public String getUsername() {
        return user.getLogin();
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


