package its.kennedy.gestione.magazzino.Repository;

import its.kennedy.gestione.magazzino.Dao.RefreshToken;
import its.kennedy.gestione.magazzino.Dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data repository for the RefreshToken entity.
 */
@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    /**
     * Finds the RefreshToken with the given id
     *
     * @param id the ID to look for
     * @return an Optional of RefreshToken
     */
    @Override
    Optional<RefreshToken> findById(Long id);

    /**
     * Finds the RefreshToken with the given token
     *
     * @param token the token to look for
     * @return an Optional of RefreshToken
     */
    Optional<RefreshToken> findByToken(String token);

    /**
     * Deletes the RefreshToken of the given User
     *
     * @param user the User whose token will be deleted
     * @return ???
     */
    int deleteByUser(User user);

    /**
     * Deletes the RefreshToken of the given token
     *
     * @param token ???
     * @return ???
     */
    int deleteByToken(String token);

}
