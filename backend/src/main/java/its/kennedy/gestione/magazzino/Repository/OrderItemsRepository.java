package its.kennedy.gestione.magazzino.Repository;

import its.kennedy.gestione.magazzino.Dao.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data repository for the OrderItem entity.
 */
@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItem, Integer> {

    List<OrderItem> getAllByAmazonOrderId(String amazonOrderId);
}
