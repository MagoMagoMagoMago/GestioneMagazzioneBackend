package its.kennedy.gestione.magazzino.Controller;

import its.kennedy.gestione.magazzino.Dao.Items;
import its.kennedy.gestione.magazzino.Dto.BaseResponsePage;
import its.kennedy.gestione.magazzino.Dto.ItemsDto;
import its.kennedy.gestione.magazzino.Service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
@Transactional
public class ItemsController {
    @Autowired
    private ItemsService itemService;

    @GetMapping("{id}")
    public ResponseEntity<ItemsDto> getItemsById(@PathVariable Integer id) {
        ItemsDto dto = null;
        try {
            dto = itemService.getById(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("pagina/{sort}/{order}/{p}/{q}")
    public ResponseEntity<BaseResponsePage<ItemsDto>> selezionapagina(@PathVariable String sort, @PathVariable Boolean order, @PathVariable Integer p, @PathVariable Integer q) {
        BaseResponsePage<ItemsDto> dto = null;
        try {
            dto = itemService.selezionaPagina(p, q, sort, order);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(produces = "application/json")
	public ResponseEntity<Boolean> updateDoc(@RequestBody Items doc) {
	 	try {
	 		return ResponseEntity.ok().body(itemService.modifica(doc));
			
			} catch (Exception e) {			
				return  ResponseEntity.ok().body(false);	
			}
			
	}

	@DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        if (itemService.deleteById(id)){
            return ResponseEntity.ok().build();
        } else{
            return  ResponseEntity.notFound().build();
        }
    }
}
