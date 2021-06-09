package its.kennedy.gestione.magazzino.IService;

import its.kennedy.gestione.magazzino.Dto.UserDto;

/**
 * Service Interface for managing {@link its.kennedy.gestione.magazzino.Dao.UserDao}.
 */
public interface IUser {
	
	/**
     * Get user by Id.
     *
     * @param Id of User.
     * @return UserDto.
     */
	UserDto getById(Integer id);

}
