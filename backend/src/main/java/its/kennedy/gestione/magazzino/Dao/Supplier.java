package its.kennedy.gestione.magazzino.Dao;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "suppliers")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @NotNull
    @Column(name = "indirizzo", length = 100, nullable = false)
    private String indirizzo;

    @NotNull
    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @NotNull
    @Column(name = "telefono", length = 100, nullable = false)
    private String telefono;

    @NotNull
    @Column(name = "nazione", length = 100, nullable = false)
    private String nazione;

    @Column(name = "note", length = 400)
    private String note;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "deleted_at")
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

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", nazione='" + nazione + '\'' +
                ", note='" + note + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
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
        Supplier supplier = (Supplier) o;
        return getId().equals(supplier.getId())
                && getName().equals(supplier.getName())
                && getIndirizzo().equals(supplier.getIndirizzo())
                && getEmail().equals(supplier.getEmail())
                && getTelefono().equals(supplier.getTelefono())
                && getNazione().equals(supplier.getNazione())
                && Objects.equals(getNote(), supplier.getNote())
                && getCreatedAt().equals(supplier.getCreatedAt())
                && Objects.equals(getUpdatedAt(), supplier.getUpdatedAt())
                && Objects.equals(getDeletedAt(), supplier.getDeletedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getIndirizzo(), getEmail(), getTelefono(), getNazione(), getNote(),
                getCreatedAt(), getUpdatedAt(), getDeletedAt());
    }
}
