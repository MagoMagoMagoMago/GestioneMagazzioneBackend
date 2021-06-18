package its.kennedy.gestione.magazzino.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import its.kennedy.gestione.magazzino.Dao.RefreshToken;
import its.kennedy.gestione.magazzino.Dao.User;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    @Override
    Optional<RefreshToken> findById(Long id);

    Optional<RefreshToken> findByToken(String token);
    
    int deleteByUser(User user);
    
    int deleteByToken(String token);

}
