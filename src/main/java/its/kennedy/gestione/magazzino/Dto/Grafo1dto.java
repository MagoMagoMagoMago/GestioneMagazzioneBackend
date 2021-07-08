package its.kennedy.gestione.magazzino.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Grafo1dto {
	@JsonProperty("ricavi")
	private Double guadagno;
	@JsonProperty("quantita")
	private Long quantita;
	
	public Grafo1dto(Double guadagno,Long q) {
		this.guadagno = guadagno;
		this.quantita=q;
	}

	public Double getGuadagno() {
		return guadagno;
	}

	public void setGuadagno(Double guadagno) {
		this.guadagno = guadagno;
	}

	public Long getQuantita() {
		return quantita;
	}

	public void setQuantita(Long quantita) {
		this.quantita = quantita;
	}
    
}
