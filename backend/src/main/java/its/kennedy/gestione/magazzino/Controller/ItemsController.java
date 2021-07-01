package its.kennedy.gestione.magazzino.Controller;

import its.kennedy.gestione.magazzino.Dao.Item;
import its.kennedy.gestione.magazzino.Dto.BaseResponsePage;
import its.kennedy.gestione.magazzino.Dto.ItemDto;
import its.kennedy.gestione.magazzino.Service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@Transactional
public class ItemsController {
    @Autowired
    private ItemsService itemService;

    @GetMapping("{id}")
    public ResponseEntity<ItemDto> getItemsById(@PathVariable Integer id) {
        ItemDto dto = null;
        try {
            dto = itemService.getById(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("pagina/{sort}/{order}/{p}/{q}")
    public ResponseEntity<BaseResponsePage<ItemDto>> selezionapagina(@PathVariable String sort, @PathVariable Boolean order, @PathVariable Integer p, @PathVariable Integer q, @RequestParam(required = false) String title) {
        BaseResponsePage<ItemDto> dto = null;
        try {
            dto = itemService.selezionaPagina(p, q, sort, order, title);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(produces = "application/json")
    public ResponseEntity<Boolean> updateDoc(@RequestBody Item doc) {
        try {
            return ResponseEntity.ok().body(itemService.addOrUpdate(doc));

        } catch (Exception e) {
            return ResponseEntity.ok().body(false);
        }
    }

    @GetMapping("/graph4")
    public ResponseEntity<List<ItemDto>> getItemsgicenza() {
        List<ItemDto> dto = null;
        try {
            dto = itemService.getBygiacenzainferiore();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        if (itemService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
