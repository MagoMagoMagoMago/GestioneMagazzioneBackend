package its.kennedy.gestione.magazzino.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Grafo2dto extends Grafo1dto {
	@JsonProperty("asin")
	private String asin;
	public Grafo2dto(Integer settimana, Double guadagno,Long q,String asin) {
		super(settimana, guadagno,q);
		this.asin=asin;
	}

}
