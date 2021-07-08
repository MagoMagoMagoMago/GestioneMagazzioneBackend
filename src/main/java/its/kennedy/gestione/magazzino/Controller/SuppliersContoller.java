package its.kennedy.gestione.magazzino.Controller;

import its.kennedy.gestione.magazzino.Dao.Supplier;
import its.kennedy.gestione.magazzino.Dto.SupplierDto;
import its.kennedy.gestione.magazzino.Dto.SupplierInsertDto;
import its.kennedy.gestione.magazzino.Dto.SupplierUpdateDto;
import its.kennedy.gestione.magazzino.Service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
@Transactional
public class SuppliersContoller {
    @Autowired
    SuppliersService supplierservice;

    @GetMapping("{id}")
    public ResponseEntity<SupplierDto> getSuppliersById(@PathVariable Integer id) {
        SupplierDto dto = null;
        try {
            dto = supplierservice.getById(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteSupplierById(@PathVariable Integer id) {
        Boolean dto = null;
        try {
            dto = supplierservice.elimina(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("all")
    public ResponseEntity<List<SupplierDto>> getAll(@RequestParam String sortBy, @RequestParam Boolean order) {
        List<SupplierDto> dto = null;
        try {
            dto = supplierservice.getAll(sortBy, order);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping(value = "update", produces = "application/json")
    public ResponseEntity<Boolean> updateDoc(@RequestBody SupplierUpdateDto doc) {
        try {
            return ResponseEntity.ok().body(supplierservice.modifica(doc));

        } catch (Exception e) {
            return ResponseEntity.ok().body(false);
        }

    }

    @PostMapping(value = "insert", produces = "application/json")
    public ResponseEntity<Supplier> insertDoc(@RequestBody SupplierInsertDto doc) {
        try {
            return ResponseEntity.ok().body(supplierservice.insert(doc));

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }
}
