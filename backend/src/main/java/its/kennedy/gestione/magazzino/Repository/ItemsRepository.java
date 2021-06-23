package its.kennedy.gestione.magazzino.Repository;

import its.kennedy.gestione.magazzino.Dao.Item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data repository for the Item entity.
 */
@Repository
public interface ItemsRepository extends JpaRepository<Item, Integer> {

	Page<Item> findAllByDeletedAt(Object object, Pageable p);
}
