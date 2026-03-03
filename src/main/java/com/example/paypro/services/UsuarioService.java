package com.example.paypro.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.paypro.dtos.UsuarioRequestDto;
import com.example.paypro.entitys.Usuario;
import com.example.paypro.repositories.UsuarioRepository;
import com.example.paypro.utils.Mapper;

@Service
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;
	private final Mapper mapper;
	private final PasswordEncoder encoder;
	
	public UsuarioService(UsuarioRepository usuarioRepository, Mapper mapper, PasswordEncoder encoder) {
		this.usuarioRepository = usuarioRepository;
		this.mapper = mapper;
		this.encoder = encoder;
	}
	
	public void cadastrarUsuario(UsuarioRequestDto dto) {
		Usuario usuario = mapper.UsuarioParaEntidade(dto);
		usuario.setSenha(encoder.encode(usuario.getSenha()));
		usuarioRepository.save(usuario);
	}
}
