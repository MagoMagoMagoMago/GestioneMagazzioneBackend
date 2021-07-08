package its.kennedy.gestione.magazzino.Repository;

import its.kennedy.gestione.magazzino.Dao.Purchase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;

/**
 * Spring Data repository for the Purchase entity.
 */
@Repository
public interface PurchasesRepository extends JpaRepository<Purchase, Integer> {

    /**
     * Finds all Purchase with the given deleted Instant paginated by the given Pageable
     *
     * @param instant  the instant to search for,
     *                 if null is given the method will return all Purchase that have not been deleted
     * @param pageable the pagination configuration
     * @return a filtered Page of Purchase
     */
    Page<Purchase> findAllByDeletedAt(Instant instant, Pageable pageable);

    Boolean existsPurchaseBySupplierId(Integer id);

}
