package its.kennedy.gestione.magazzino.Repository;

import its.kennedy.gestione.magazzino.Dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * Spring Data repository for the User entity.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds a User with the given username
     *
     * @param username username of the User to look for
     * @return an Optional of User
     */
    Optional<User> findByUsername(String username);

    /**
     * Check if a User exists
     *
     * @param username username of the User to look for
     * @return True if the User exists, false otherwise
     */
    Boolean existsByUsername(String username);

    /**
     * Check if a User exists
     *
     * @param email email of the User to look for
     * @return True if the User exists, false otherwise
     */
    Boolean existsByEmail(String email);
}