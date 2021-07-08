package its.kennedy.gestione.magazzino.Controller;

import its.kennedy.gestione.magazzino.Dao.Purchase;
import its.kennedy.gestione.magazzino.Dto.BaseResponsePage;
import its.kennedy.gestione.magazzino.Dto.PurchaseDto;
import its.kennedy.gestione.magazzino.Service.PurchasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/purchases")
@Transactional
public class PurchasesController {
    @Autowired
    PurchasesService purchaseService;

    @GetMapping("pagina/{sort}/{ord}/{p}/{q}")
    public ResponseEntity<BaseResponsePage<PurchaseDto>> selezionapagina(@PathVariable String sort, @PathVariable Boolean ord, @PathVariable Integer p, @PathVariable Integer q) {
        BaseResponsePage<PurchaseDto> dto = null;
        try {
            dto = purchaseService.selezionaPagina(p, q, sort, ord);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("{id}")
    public ResponseEntity<PurchaseDto> getItemsById(@PathVariable Integer id) {
        PurchaseDto dto = null;
        try {
            dto = purchaseService.getById(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<Boolean> eliminaItemsById(@PathVariable Integer id) {
        Boolean dto = null;
        try {
            dto = purchaseService.elimina(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(produces = "application/json")
    public ResponseEntity<Boolean> updateDoc(@RequestBody Purchase doc) {
        try {
            return ResponseEntity.ok().body(purchaseService.modifica(doc));

        } catch (Exception e) {
            return ResponseEntity.ok().body(false);
        }

    }
    
    @PutMapping(value="/insert", produces = "application/json")
    public ResponseEntity<Integer> inser(@RequestBody Purchase doc) {
        try {
            return ResponseEntity.ok().body(purchaseService.insert(doc));

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }
}
