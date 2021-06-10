package its.kennedy.gestione.magazzino.IService;

import its.kennedy.gestione.magazzino.Dao.User;
import its.kennedy.gestione.magazzino.Dto.UserDto;

/**
 * Service Interface for managing {@link User}.
 */
public interface IUser {

    /**
     * Get user by Id.
     *
     * @param id of User.
     * @return UserDto.
     */
    UserDto getById(Integer id);

    /**
     * Checks if password and email belongs to the same user.
     *
     * @param email    email of the user
     * @param password password of the user
     * @return True if the email and password are correct, false otherwise
     */
    Boolean login(String email, String password);
}
