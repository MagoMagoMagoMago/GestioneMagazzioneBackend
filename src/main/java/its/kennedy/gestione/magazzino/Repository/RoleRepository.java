package its.kennedy.gestione.magazzino.Repository;

import its.kennedy.gestione.magazzino.Dao.ERole;
import its.kennedy.gestione.magazzino.Dao.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data repository for the Role entity.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     * Finds a role with the given name
     *
     * @param name ERole type enum of the role to find
     * @return an Optional of Role
     */
    Optional<Role> findByName(ERole name);
}