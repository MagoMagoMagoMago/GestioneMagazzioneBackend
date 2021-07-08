package its.kennedy.gestione.magazzino.Repository;

import its.kennedy.gestione.magazzino.Dao.Supplier;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Spring Data repository for the Supplier entity.
 */
@Repository
public interface SuppliersRepository extends JpaRepository<Supplier, Integer> {
	@Query("SELECT cor FROM Supplier cor where cor.deletedAt is null")
	List<Supplier> findByDeletedAt(Sort by);
}
