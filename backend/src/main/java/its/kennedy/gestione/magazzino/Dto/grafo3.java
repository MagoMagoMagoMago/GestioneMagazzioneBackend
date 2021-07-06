package its.kennedy.gestione.magazzino.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class grafo3 extends Grafo1dto {
	public grafo3(Double guadagno, Long q,String categoria) {
		super(guadagno, q);
	}

	@JsonProperty("categoria")
	private String categoria;

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
