package its.kennedy.gestione.magazzino.Repository;

import its.kennedy.gestione.magazzino.Dao.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data repository for the Category entity.
 */
@Repository
public interface CategoriesRepository extends JpaRepository<Category, Integer> {
}
