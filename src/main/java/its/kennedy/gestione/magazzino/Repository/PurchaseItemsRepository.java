package its.kennedy.gestione.magazzino.Repository;

import its.kennedy.gestione.magazzino.Dao.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data repository for the PurchaseItem entity.
 */
@Repository
public interface PurchaseItemsRepository extends JpaRepository<PurchaseItem, Integer> {

    /**
     * Finds all the PurchaseItem with the given purchase_id
     *
     * @param purchaseId the purchase_id to find
     * @return a List of PurchaseItem
     */
    @Query("SELECT cor FROM #{#entityName} cor WHERE cor.purchase_id = ?1")
    List<PurchaseItem> findAllByPurchase_id(Integer purchaseId);
}
