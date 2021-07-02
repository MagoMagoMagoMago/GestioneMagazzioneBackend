package its.kennedy.gestione.magazzino.Repository;

import its.kennedy.gestione.magazzino.Dao.OrderItem;
import its.kennedy.gestione.magazzino.Dto.Grafo1dto;
import its.kennedy.gestione.magazzino.Dto.Grafo2dto;

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
	@Query("SELECT new  its.kennedy.gestione.magazzino.Dto.Grafo1dto((YEAR(cor.order.purchaseDate)*100 +WEEK(cor.order.purchaseDate)) as c , sum(cor.itemPriceAmount),sum(cor.quantityOrdered)) FROM OrderItem cor where cor.order.purchaseDate > ?1  and cor.order.purchaseDate < ?2 group by c")
	List<Grafo1dto> getDateBetween(Instant inizio,Instant fine);
	@Query("SELECT new  its.kennedy.gestione.magazzino.Dto.Grafo2dto((YEAR(cor.order.purchaseDate)*100 +WEEK(cor.order.purchaseDate)) as c , sum(cor.itemPriceAmount),sum(cor.quantityOrdered),cor.asin) FROM OrderItem cor where cor.order.purchaseDate > ?1  and cor.order.purchaseDate < ?2 group by c ,cor.asin")
	List<Grafo2dto> getDateBetweenitem(Instant inizio,Instant fine);
	@Query("SELECT cor FROM OrderItem cor where cor.order.amazonOrderId = ?1")
    List<OrderItem> getAllByAmazonOrderId(String amazonOrderId);
	
}
