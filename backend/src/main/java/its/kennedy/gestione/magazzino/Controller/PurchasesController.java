package its.kennedy.gestione.magazzino.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import its.kennedy.gestione.magazzino.Dao.Purchases;
import its.kennedy.gestione.magazzino.Dto.BaseResponsePage;
import its.kennedy.gestione.magazzino.Dto.PurchasesDto;
import its.kennedy.gestione.magazzino.Service.PurchasesService;

@RestController
@RequestMapping("/api/purchases")
@Transactional
public class PurchasesController {
	@Autowired
	PurchasesService supplierservice;
	 @GetMapping("pagina/{ord}/{p}/{q}")
	    public ResponseEntity<BaseResponsePage<PurchasesDto>> selezionapagina(@PathVariable String ord, @PathVariable Integer p, @PathVariable Integer q) {
	        BaseResponsePage<PurchasesDto> dto = null;
	        try {
	            dto = supplierservice.selezionaPagina(p, q, ord, true);
	        } catch (Exception e) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok().body(dto);
	    }
	    @GetMapping("{id}")
	    public ResponseEntity<PurchasesDto> getItemsById(@PathVariable Integer id) {
	        PurchasesDto dto = null;
	        try {
	            dto = supplierservice.getById(id);
	        } catch (Exception e) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok().body(dto);
	    }
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
	    @PutMapping(produces = "application/json")
		public ResponseEntity<Boolean> updateDoc(@RequestBody Purchases doc) {
		 	try {
		 		return ResponseEntity.ok().body(supplierservice.modifica(doc));
				
				} catch (Exception e) {			
					return  ResponseEntity.ok().body(false);	
				}
				
		}
}
