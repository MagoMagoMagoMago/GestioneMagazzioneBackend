package its.kennedy.gestione.magazzino.Dao;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "suppliers")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Suppliers implements Serializable {

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
    @Column(name = "rmail", length = 100, nullable = false)
    private String rmail;
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

    public String getRmail() {
        return rmail;
    }

    public void setRmail(String rmail) {
        this.rmail = rmail;
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
    public boolean equals(Object obj) {
        if (this == obj) {
			return true;
		}
        if (obj == null) {
			return false;
		}
        if (getClass() != obj.getClass()) {
			return false;
		}
        Suppliers other = (Suppliers) obj;
        if (createdAt == null) {
            if (other.createdAt != null) {
				return false;
			}
        } else if (!createdAt.equals(other.createdAt)) {
			return false;
		}
        if (deletedAt == null) {
            if (other.deletedAt != null) {
				return false;
			}
        } else if (!deletedAt.equals(other.deletedAt)) {
			return false;
		}
        if (id == null) {
            if (other.id != null) {
				return false;
			}
        } else if (!id.equals(other.id)) {
			return false;
		}
        if (indirizzo == null) {
            if (other.indirizzo != null) {
				return false;
			}
        } else if (!indirizzo.equals(other.indirizzo)) {
			return false;
		}
        if (name == null) {
            if (other.name != null) {
				return false;
			}
        } else if (!name.equals(other.name)) {
			return false;
		}
        if (nazione == null) {
            if (other.nazione != null) {
				return false;
			}
        } else if (!nazione.equals(other.nazione)) {
			return false;
		}
        if (note == null) {
            if (other.note != null) {
				return false;
			}
        } else if (!note.equals(other.note)) {
			return false;
		}
        if (rmail == null) {
            if (other.rmail != null) {
				return false;
			}
        } else if (!rmail.equals(other.rmail)) {
			return false;
		}
        if (telefono == null) {
            if (other.telefono != null) {
				return false;
			}
        } else if (!telefono.equals(other.telefono)) {
			return false;
		}
        if (updatedAt == null) {
            if (other.updatedAt != null) {
				return false;
			}
        } else if (!updatedAt.equals(other.updatedAt)) {
			return false;
		}
        return true;
    }

}
