package its.kennedy.gestione.magazzino.Dao;

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
@Table(name = "items")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class ItemsDao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
    private Integer id;
	@NotNull
    @Column(name = "asin", length = 100, nullable = false)
    private String asin;
	@NotNull
    @Column(name = "title", length = 100, nullable = false)
    private String title;
	@NotNull
    @Column(name = "description", length = 400, nullable = false)
    private String description;
	@NotNull
    @Column(name = "price", nullable = false)
    private Double price;
	@NotNull
    @Column(name = "storage", length = 100, nullable = false)
    private int storage;	
	@NotNull
    @Column(name = "min_availability", nullable = false)
    private int min_availability;	
	@NotNull
    @Column(name = "image", length = 400, nullable = false)
    private String image;
	@NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;
	
	@NotNull
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;
	
	@NotNull
    @Column(name = "deleted_at", nullable = false)
    private Instant deletedAt;
	@NotNull
    @Column(name = "category_id", length = 100, nullable = false)
    private int category_id;	
	
	
	
}
