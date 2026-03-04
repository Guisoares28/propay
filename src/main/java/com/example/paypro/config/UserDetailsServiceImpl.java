package com.example.paypro.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.paypro.entitys.Usuario;
import com.example.paypro.repositories.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private final UsuarioRepository repository;
	
	public UserDetailsServiceImpl(UsuarioRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = repository.findById(email).orElseThrow(
				() -> new RuntimeException("Usuário não encontrado"));
		
		return User.builder()
				.username(usuario.getEmail())
				.password(usuario.getSenha())
				.build();
				
	}

}
