package its.kennedy.gestione.magazzino.Dao;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "purchase_items")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class purchaseItems implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "purchase_id", nullable = false)
    private Integer purchase_id;

    @NotNull
    @Column(name = "item_id", nullable = false)
    private Integer item_id;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @NotNull
    @Column(name = "unit_price", nullable = false)
    private Double unit_price;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant created_at;

    @Column(name = "updated_at")
    private Instant updated_at;

    @Column(name = "deleted_at")
    private Instant deleted_at;
}
