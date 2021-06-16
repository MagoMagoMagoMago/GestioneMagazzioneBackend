package its.kennedy.gestione.magazzino.Controller;

import its.kennedy.gestione.magazzino.Dao.User;
import its.kennedy.gestione.magazzino.Dto.UserDto;
import its.kennedy.gestione.magazzino.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing {@link User}.
 */
@RestController
@RequestMapping("/api/user")
@Transactional
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * {@code GET  /user/{id}} : Get User by id.
     *
     * @param id
     * @return the {@link ResponseEntity<UserDto>} with status {@code 200 (OK)} and with body
     * the UserDto, or with status {@code 404 (Not Found)}
     */
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer id) {
        UserDto dto = null;
        try {
            dto = userService.getById(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dto);
    }
}
