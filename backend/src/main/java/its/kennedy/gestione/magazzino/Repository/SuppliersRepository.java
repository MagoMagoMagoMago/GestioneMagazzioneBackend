package its.kennedy.gestione.magazzino.Repository;

import its.kennedy.gestione.magazzino.Dao.Supplier;

import java.time.Instant;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data repository for the Supplier entity.
 */
@Repository
public interface SuppliersRepository extends JpaRepository<Supplier, Integer> {

	List<Supplier> findByDeleteAtOrderBy(Instant instant,String or);
}
