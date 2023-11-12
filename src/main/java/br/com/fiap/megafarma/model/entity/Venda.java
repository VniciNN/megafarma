package br.com.fiap.megafarma.model.entity;

import java.time.LocalDate;

public class Venda {
	private Long id;
	private LocalDate dataVenda;
	private Long idCliente;
	
	public Venda() {
		
	}

	public Venda(Long id, LocalDate dataVenda, Long idCliente) {
		this.id = id;
		this.dataVenda = dataVenda;
		this.idCliente = idCliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	
	
}
