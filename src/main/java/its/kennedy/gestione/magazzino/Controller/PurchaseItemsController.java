package its.kennedy.gestione.magazzino.Controller;

import its.kennedy.gestione.magazzino.Dao.PurchaseItem;
import its.kennedy.gestione.magazzino.Dto.PurchaseItemDto;
import its.kennedy.gestione.magazzino.Dto.PurchaseItemDtoInsert;
import its.kennedy.gestione.magazzino.Service.PurchaseItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchaseItems")
@Transactional
public class PurchaseItemsController {
    @Autowired
    PurchaseItemsService supplierservice;

    @GetMapping("delete/{id}")
    public ResponseEntity<Boolean> eliminaItemsById(@PathVariable Integer id) {
        Boolean dto = null;
        try {
            dto = supplierservice.elimina(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("{id}")
    public ResponseEntity<PurchaseItemDto> getItemsById(@PathVariable Integer id) {
        PurchaseItemDto dto = null;
        try {
            dto = supplierservice.getById(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("purchase/{id}")
    public ResponseEntity<List<PurchaseItemDto>> getItemsBypurchase(@PathVariable Integer id) {
        List<PurchaseItemDto> dto = null;
        try {
            dto = supplierservice.getByPurchase(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(produces = "application/json")
    public ResponseEntity<Boolean> updateDoc(@RequestBody PurchaseItem doc) {
        try {
            return ResponseEntity.ok().body(supplierservice.modifica(doc));

        } catch (Exception e) {
            return ResponseEntity.ok().body(false);
        }
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<Boolean> insertPurchaseItems(@RequestBody List<PurchaseItemDtoInsert> purchaseItems) {
        try {
            return ResponseEntity.ok().body(supplierservice.addPurchases(purchaseItems));
        } catch (Exception e) {
            return ResponseEntity.ok().body(false);
        }
    }
}
