package com.gamestore.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamestore.config.DetailUserData;
import com.gamestore.model.Login;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	public static final int TOKEN_EXPIRACAO = 1_800_000;

	public static final String TOKEN_SENHA = "GAME-STORE-GPS";

	private final AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			Login client = new ObjectMapper().readValue(request.getInputStream(), Login.class);

			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(client.getEmail(),
					client.getPassword(), new ArrayList<>()));

		} catch (IOException e) {
			throw new RuntimeException("Authentication Failed!", e);
		}

	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		DetailUserData clientData = (DetailUserData) authResult.getPrincipal();

		String token = JWT.create().withSubject(clientData.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRACAO))
				.sign(Algorithm.HMAC512(TOKEN_SENHA));

		// response.addHeader("responseType", "text");
		response.getWriter().write(token);
		response.getWriter().flush();
	}
}
