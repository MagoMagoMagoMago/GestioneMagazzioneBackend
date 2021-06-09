package its.kennedy.gestione.magazzino.Dao;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "categories")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class CategoriesDao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	@NotNull
    @Column(name = "name", length = 100, nullable = false)
    private String name;
	@NotNull
	@Column(name = "created_at", nullable = false)
	private Instant createdAt;	
	@Column(name = "updated_at")
	private Instant updatedAt;	
	@Column(name = "deleted_at")
	private Instant deletedAt;
	@Column(name = "description", length = 400)
	private String description;
	
}
