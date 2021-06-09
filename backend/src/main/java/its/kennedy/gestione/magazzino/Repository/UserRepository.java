package its.kennedy.gestione.magazzino.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import its.kennedy.gestione.magazzino.Dao.UserDao;

/**
 * Spring Data repository for the UserDao entity.
 */
@Repository
public interface UserRepository extends JpaRepository<UserDao, Integer> {

	Optional<UserDao> findById(Integer id);
}
