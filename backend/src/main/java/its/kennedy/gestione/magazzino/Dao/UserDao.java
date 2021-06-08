package its.kennedy.gestione.magazzino.Dao;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A user.
 */
@Entity
@Table(name = "users")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class UserDao implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
    private Integer id;
	
	@NotNull
    @Column(name = "name", length = 100, nullable = false)
    private String name;
	
	@NotNull
    @Column(name = "surname", length = 100, nullable = false)
    private String surname;
	
	@NotNull
    @Column(name = "born_at", length = 100, nullable = false)
    private String bornAt;
	
	@NotNull
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;
	
	@NotNull
    @Column(name = "email", length = 100, unique = true, nullable = false)
    private String email;
	
	@NotNull
    @Column(name = "username", length = 100, unique = true, nullable = false)
    private String username;
	
    @NotNull
    @Size(max = 100)
    @Column(name = "password", length = 100, nullable = false)
    private String password;
	
	@NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;
	
	@NotNull
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;
	
	@NotNull
    @Column(name = "deleted_at", nullable = false)
    private Instant deletedAt;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getBornAt() {
		return bornAt;
	}

	public void setBornAt(String bornAt) {
		this.bornAt = bornAt;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Instant getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Instant deletedAt) {
		this.deletedAt = deletedAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
