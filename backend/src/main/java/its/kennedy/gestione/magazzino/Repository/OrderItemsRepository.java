package its.kennedy.gestione.magazzino.Repository;

import its.kennedy.gestione.magazzino.Dao.OrderItem;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data repository for the OrderItem entity.
 */
@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItem, Integer> {
	@Query("SELECT cor FROM OrderItem cor where cor.amazonOrderId.date.purchaseDate > ?1  and cor.amazonOrderId.date.purchaseDate < ?2")
	List<OrderItem> getDateBetween(Instant inizio,Instant fine);

    List<OrderItem> getAllByAmazonOrderId(String amazonOrderId);
}
