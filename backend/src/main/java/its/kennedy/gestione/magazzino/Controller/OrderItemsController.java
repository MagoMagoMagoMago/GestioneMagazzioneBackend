package its.kennedy.gestione.magazzino.Controller;

import its.kennedy.gestione.magazzino.Dto.Grafo1dto;
import its.kennedy.gestione.magazzino.Dto.Grafo2dto;
import its.kennedy.gestione.magazzino.Dto.OrderItemDto;
import its.kennedy.gestione.magazzino.Dto.grafo3;
import its.kennedy.gestione.magazzino.Service.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/orderItems")
@Transactional
public class OrderItemsController {

	@Autowired
	OrderItemsService orderItemsService;

	@GetMapping("{amazonOrderId}")
    public ResponseEntity<List<OrderItemDto>> getOrderItemsByAmazonOrderId(@PathVariable String amazonOrderId) {
        List<OrderItemDto> orderItemDtoList = null;
        try {
            orderItemDtoList = orderItemsService.getAllByAmazonOrderId(amazonOrderId);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(orderItemDtoList);
    }

	@GetMapping("between/{inizio}/{fine}/{asin}")
    public ResponseEntity<Grafo1dto> getOrderbetween(@PathVariable Instant inizio, @PathVariable Instant fine,@PathVariable String asin) {
        Grafo1dto orderItemDtoList = null;
        try {
        	
        		 orderItemDtoList = orderItemsService.getDateBetween(inizio, fine, asin)	;
        	
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(orderItemDtoList);
    }
	@GetMapping("between/{inizio}/{fine}")
    public ResponseEntity<Grafo1dto> getOrderbetween(@PathVariable Instant inizio, @PathVariable Instant fine) {
        Grafo1dto orderItemDtoList = null;
        try {
            orderItemDtoList = orderItemsService.getDateBetween(inizio, fine);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(orderItemDtoList);
    }
	@GetMapping("betweenitem/{inizio}/{fine}")
    public ResponseEntity<List<Grafo2dto>> getOrderbetweenitem(@PathVariable Instant inizio, @PathVariable Instant fine) {
        List<Grafo2dto> orderItemDtoList = null;
        try {
        	
            orderItemDtoList = orderItemsService.getDateBetweenitem(inizio, fine);
        	
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(orderItemDtoList);
    }
	@GetMapping("betweencategorie/{inizio}/{fine}")
    public ResponseEntity<List<grafo3>> getOrderbetweencategorie(@PathVariable Instant inizio, @PathVariable Instant fine) {
        List<grafo3> orderItemDtoList = null;
        try {
            orderItemDtoList = orderItemsService.getDateBetweencategorie(inizio, fine);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(orderItemDtoList);
    }
}
