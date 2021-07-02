package its.kennedy.gestione.magazzino.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Grafo2dto extends Grafo1dto {
	@JsonProperty("asin")
	private String asin;
	public Grafo2dto(Double guadagno,Long q,String asin) {
		super(guadagno,q);
		this.asin=asin;
	}

}
