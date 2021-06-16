package its.kennedy.gestione.magazzino.Repository;

import its.kennedy.gestione.magazzino.Dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data repository for the UserDao entity.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmailAndPassword(String email, String password);

}
