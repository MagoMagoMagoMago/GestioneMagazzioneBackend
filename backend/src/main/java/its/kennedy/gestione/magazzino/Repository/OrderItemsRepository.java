package its.kennedy.gestione.magazzino.Repository;

import its.kennedy.gestione.magazzino.Dao.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data repository for the OrderItem entity.
 */
@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItem, Integer> {
}
