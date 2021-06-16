package its.kennedy.gestione.magazzino.Repository;

import its.kennedy.gestione.magazzino.Dao.PurchaseItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseItemsRepository extends JpaRepository<PurchaseItems, Integer> {
}
