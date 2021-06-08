package its.kennedy.gestione.magazzino.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import its.kennedy.gestione.magazzino.Dto.UserDto;
import its.kennedy.gestione.magazzino.IService.IUser;
import its.kennedy.gestione.magazzino.Repository.UserRepository;

@Service
public class UserService implements IUser{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto getById(Integer Id) {
		return modelMapper.map(userRepository.getById(Id), UserDto.class);
	}

}
