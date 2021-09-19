package com.gamestore.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gamestore.model.Client;

public class DetailUserData implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	private final Optional<Client> client;

    public DetailUserData(Optional<Client> user) {
        this.client = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return client.orElse(new Client()).getPassword();
    }

    @Override
    public String getUsername() {
        return client.orElse(new Client()).getEmail();
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
