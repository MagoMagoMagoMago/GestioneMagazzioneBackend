package its.kennedy.gestione.magazzino.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import its.kennedy.gestione.magazzino.Dto.UserDto;
import its.kennedy.gestione.magazzino.Service.UserService;

@RestController
@RequestMapping("/api")
@Transactional
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/user/{id}")
	public UserDto getUserById(@PathVariable Integer id) {
		return userService.getById(id);
	}
}
