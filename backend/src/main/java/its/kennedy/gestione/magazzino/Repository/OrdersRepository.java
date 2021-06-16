package its.kennedy.gestione.magazzino.Repository;

import its.kennedy.gestione.magazzino.Dao.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
}
