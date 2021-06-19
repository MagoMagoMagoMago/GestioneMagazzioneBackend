package its.kennedy.gestione.magazzino.Repository;

import its.kennedy.gestione.magazzino.Dao.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data repository for the Order entity.
 */
@Repository
public interface OrdersRepository extends JpaRepository<Order, String> {

    /**
     * Finds all the Order IDs
     *
     * @return a List of String
     */
    @Query("SELECT id FROM #{#entityName}")
    List<String> findAllIds();
}
