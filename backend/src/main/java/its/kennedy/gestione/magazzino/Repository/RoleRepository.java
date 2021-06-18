package its.kennedy.gestione.magazzino.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import its.kennedy.gestione.magazzino.Dao.ERole;
import its.kennedy.gestione.magazzino.Dao.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}