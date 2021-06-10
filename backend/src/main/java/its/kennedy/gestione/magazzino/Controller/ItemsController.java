package its.kennedy.gestione.magazzino.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import its.kennedy.gestione.magazzino.Dto.ItemsDto;
import its.kennedy.gestione.magazzino.Service.ItemsService;

@RestController
@RequestMapping("/api/items")
@Transactional
public class ItemsController {
	@Autowired
	private ItemsService itemService;
	@GetMapping("{id}")
	public ResponseEntity<ItemsDto> getItemsById(@PathVariable Integer id){
		ItemsDto dto = null;
		try {
			dto = itemService.getById(id);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(dto);
	}
	@GetMapping("pagina/{ord}/{p}/{q}")
	public ResponseEntity<List<ItemsDto>> selezionapagina(@PathVariable String ord,@PathVariable Integer p,@PathVariable Integer q){
		List<ItemsDto> dto = null;
		try {
			dto = itemService.selezionapagina(p,q,ord,true);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(dto);
	}
}
