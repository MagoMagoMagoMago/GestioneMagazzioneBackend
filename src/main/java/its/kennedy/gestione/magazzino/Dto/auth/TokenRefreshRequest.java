package its.kennedy.gestione.magazzino.Dto.auth;

import javax.validation.constraints.NotBlank;

public class TokenRefreshRequest {

	@NotBlank
	private String refreshToken;

	@NotBlank
	private String expiredToken;

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getExpiredToken() {
		return expiredToken;
	}

	public void setExpiredToken(String expiredToken) {
		this.expiredToken = expiredToken;
	}

}
