package its.kennedy.gestione.magazzino.Dto;

import java.time.Instant;

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

}
