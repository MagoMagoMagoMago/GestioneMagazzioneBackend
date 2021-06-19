package its.kennedy.gestione.magazzino.Repository;

import its.kennedy.gestione.magazzino.Dao.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data repository for the Supplier entity.
 */
@Repository
public interface SuppliersRepository extends JpaRepository<Supplier, Integer> {
}
