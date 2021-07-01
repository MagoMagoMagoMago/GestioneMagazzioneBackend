package its.kennedy.gestione.magazzino.Repository;

import its.kennedy.gestione.magazzino.Dao.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data repository for the Item entity.
 */
@Repository
public interface ItemsRepository extends JpaRepository<Item, Integer> {

    Page<Item> findAllByDeletedAt(Object object, Pageable p);

    Item getByAsin(String asin);

    @Query("SELECT cor FROM Item cor where cor.storage < cor.minAvailability")
    List<Item> getBygiacenzainferiore();

    Page<Item> findByDeletedAtAndTitleContainingIgnoreCase(Object object, String title, Pageable pageable);

}
