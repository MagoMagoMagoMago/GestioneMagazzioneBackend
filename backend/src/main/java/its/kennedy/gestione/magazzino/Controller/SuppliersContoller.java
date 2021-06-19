package its.kennedy.gestione.magazzino.Controller;

import its.kennedy.gestione.magazzino.Dao.Supplier;
import its.kennedy.gestione.magazzino.Dto.SuppliersDto;
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
    public ResponseEntity<SuppliersDto> getSuppliersById(@PathVariable Integer id) {
        SuppliersDto dto = null;
        try {
            dto = supplierservice.getById(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("all")
    public ResponseEntity<List<SuppliersDto>> selezionapagina() {
        List<SuppliersDto> dto = null;
        try {
            dto = supplierservice.getAll();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(produces = "application/json")
    public ResponseEntity<Boolean> updateDoc(@RequestBody Supplier doc) {
        try {
            return ResponseEntity.ok().body(supplierservice.modifica(doc));

        } catch (Exception e) {
            return ResponseEntity.ok().body(false);
        }

    }
}
