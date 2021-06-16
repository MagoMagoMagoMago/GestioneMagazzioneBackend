package its.kennedy.gestione.magazzino.Repository;


import its.kennedy.gestione.magazzino.Dao.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Items, Integer> {


}
