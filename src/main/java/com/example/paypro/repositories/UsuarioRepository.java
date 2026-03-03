package com.example.paypro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.paypro.entitys.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	
}

