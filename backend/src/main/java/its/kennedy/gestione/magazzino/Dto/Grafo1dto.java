package its.kennedy.gestione.magazzino.Dto;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Grafo1dto {
	@JsonProperty("settimana")
	private Instant settimana;
	@JsonProperty("ricavi")
	private Double guadagno;
	@JsonProperty("quantita")
	private Long quantita;
	
	public Grafo1dto(Integer settimana, Double guadagno,Long q) {
		this.settimana =Instant.parse(settimana/100+"-01-01T00:00:00.00Z").plusSeconds(604800*(settimana%100));
		this.guadagno = guadagno;
		this.quantita=q;
	}

}
