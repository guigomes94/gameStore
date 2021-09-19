package com.gamestore.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.gamestore.config.DetailUserData;
import com.gamestore.model.Client;
import com.gamestore.repository.ClientRepository;

@Component
public class DetailUserServiceImpl implements UserDetailsService {

	private final ClientRepository repository;

    public DetailUserServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Client> user = repository.findByEmail(email);
		if (user.isEmpty()) {
			throw new UsernameNotFoundException("Client [" + email + "] not found!");
		}

		return new DetailUserData(user);
	}

}
