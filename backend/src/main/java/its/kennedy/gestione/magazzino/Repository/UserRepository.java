package its.kennedy.gestione.magazzino.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import its.kennedy.gestione.magazzino.Dao.UserDao;

@Repository
public interface UserRepository extends JpaRepository<UserDao, Integer> {

	Optional<UserDao> findById(Integer Id);
}
