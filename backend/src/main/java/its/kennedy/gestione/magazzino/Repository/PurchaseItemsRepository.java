package its.kennedy.gestione.magazzino.Repository;

import its.kennedy.gestione.magazzino.Dao.PurchaseItems;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseItemsRepository extends JpaRepository<PurchaseItems, Integer> {

	@Query("SELECT cor FROM PurchaseItems cor WHERE cor.purchase_id = ?1")
	List<PurchaseItems> findAllByPurchase_id(int id);
}
