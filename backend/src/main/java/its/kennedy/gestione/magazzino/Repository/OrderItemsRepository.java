package its.kennedy.gestione.magazzino.Repository;

import its.kennedy.gestione.magazzino.Dao.OrderItem;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Spring Data repository for the OrderItem entity.
 */
@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItem, Integer> {
	@Query("SELECT cor FROM OrderItem cor where cor.order.purchaseDate > ?1  and cor.order.purchaseDate < ?2")
	List<OrderItem> getDateBetween(Instant inizio,Instant fine);
	@Query("SELECT cor FROM OrderItem cor where cor.order.amazonOrderId = ?1")
    List<OrderItem> getAllByAmazonOrderId(String amazonOrderId);
	
}
