package br.com.fiap.megafarma.model.entity;

public class ItensVendidos {
	private Long id;
	private Long idRemedio;
	private int quantidade;
	
	public ItensVendidos() {
		
	}

	public ItensVendidos(Long id, Long idRemedio, int quantidade) {
		this.id = id;
		this.idRemedio = idRemedio;
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdRemedio() {
		return idRemedio;
	}

	public void setIdRemedio(Long idRemedio) {
		this.idRemedio = idRemedio;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
