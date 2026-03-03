package com.example.paypro.utils;

import org.springframework.stereotype.Component;

import com.example.paypro.dtos.UsuarioRequestDto;
import com.example.paypro.entitys.Usuario;

@Component
public class Mapper {
	
	public Mapper() {}
	
	public Usuario UsuarioParaEntidade(UsuarioRequestDto dto) {
		return new Usuario(dto.getEmail(), dto.getEmail(), dto.getNome());
	}
	
}
