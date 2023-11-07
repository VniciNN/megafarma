package br.com.fiap.megafarma.model.entity;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class Cliente {
	
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	private String cpf;
	@NotBlank
	private String email;
	@PastOrPresent
	private LocalDate data_de_nascimento;
	
	public Cliente() {
		
	}


	public Cliente(@NotBlank Long id, @NotNull String nome, @NotNull String cpf, @NotNull String email,
			@PastOrPresent LocalDate data_de_nascimento) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.data_de_nascimento = data_de_nascimento;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public LocalDate getData_de_nascimento() {
		return data_de_nascimento;
	}


	public void setData_de_nascimento(LocalDate localDate) {
		this.data_de_nascimento = localDate;
	}
	
	
}
