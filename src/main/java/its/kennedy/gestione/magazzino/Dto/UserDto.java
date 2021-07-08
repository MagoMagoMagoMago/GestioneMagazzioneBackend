package its.kennedy.gestione.magazzino.Dto;

import java.util.Objects;

public class UserDto {

    private Long id;

    private String email;

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
			return true;
		}
        if (o == null || getClass() != o.getClass()) {
			return false;
		}
        UserDto userDto = (UserDto) o;
        return Objects.equals(getId(), userDto.getId())
                && Objects.equals(getEmail(), userDto.getEmail())
                && Objects.equals(getPassword(), userDto.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getPassword());
    }
}
