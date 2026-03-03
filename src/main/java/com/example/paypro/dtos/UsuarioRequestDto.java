package com.example.paypro.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UsuarioRequestDto {
	
		@NotBlank(message="Email não pode estar vazio")
		@NotNull(message="Email não pode ser nulo")
		@Email(message="Email inválido")
		private String email;
		
		@NotBlank(message="Senha não pode estar vazio")
		@NotNull(message="Senha não pode ser nulo")
		private String senha;
		
		@NotBlank(message="Nome não pode estar vazio")
		@NotNull(message="Nome não pode ser nulo")
		private String nome;

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
}
