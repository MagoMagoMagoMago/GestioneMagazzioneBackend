package its.kennedy.gestione.magazzino.Controller;

import its.kennedy.gestione.magazzino.Dto.OrdersDto;
import its.kennedy.gestione.magazzino.Service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@Transactional
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("{id}")
    public ResponseEntity<OrdersDto> getItemsById(@PathVariable Integer id) {
        OrdersDto dto = null;
        try {
            dto = ordersService.getById(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("pagina/{ord}/{p}/{q}")
    public ResponseEntity<List<OrdersDto>> selezionapagina(@PathVariable String ord, @PathVariable Integer p, @PathVariable Integer q) {
        List<OrdersDto> dto = null;
        try {
            dto = ordersService.selezionaPagina(p, q, ord, true);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dto);
    }
}
