package com.example.paypro.entitys;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_usuarios")
public class Usuario {
	@Id
	private String email;
	
	private String senha;
	
	private String nome;
	
	@OneToMany(mappedBy="usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Titulo> titulos = new ArrayList<>();

	public Usuario() {
		
	}
	
	public Usuario(String email, String senha, String nome) {
		super();
		this.email = email;
		this.senha = senha;
		this.nome = nome;
	}

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

	public List<Titulo> getTitulos() {
		return titulos;
	}

	public void setTitulos(List<Titulo> titulos) {
		this.titulos = titulos;
	}
}
