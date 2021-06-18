package its.kennedy.gestione.magazzino.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import its.kennedy.gestione.magazzino.Dao.PurchaseItems;
import its.kennedy.gestione.magazzino.Dto.PurchaseItemsDto;
import its.kennedy.gestione.magazzino.Service.PurchaseItemsService;

@RestController
@RequestMapping("/api/purchaseitems")
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
    public ResponseEntity<PurchaseItemsDto> getItemsById(@PathVariable Integer id) {
        PurchaseItemsDto dto = null;
        try {
            dto = supplierservice.getById(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dto);
    }
    @GetMapping("prucase/{id}")
    public ResponseEntity<List<PurchaseItemsDto>> getItemsBypurchase(@PathVariable Integer id) {
        List<PurchaseItemsDto> dto = null;
        try {
            dto = supplierservice.getByPurchase(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dto);
    }
    @PutMapping(produces = "application/json")
	public ResponseEntity<Boolean> updateDoc(@RequestBody PurchaseItems doc) {
	 	try {
	 		return ResponseEntity.ok().body(supplierservice.modifica(doc));
			
			} catch (Exception e) {			
				return  ResponseEntity.ok().body(false);	
			}
			
	}
}
