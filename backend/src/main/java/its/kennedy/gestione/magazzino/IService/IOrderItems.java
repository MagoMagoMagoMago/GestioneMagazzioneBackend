package its.kennedy.gestione.magazzino.IService;

import its.kennedy.gestione.magazzino.Dto.Grafo1dto;
import its.kennedy.gestione.magazzino.Dto.Grafo2dto;
import its.kennedy.gestione.magazzino.Dto.OrderItemDto;

import java.time.Instant;
import java.util.List;

public interface IOrderItems {

    /**
     * Get orderItem by Id.
     *
     * @param id of orderItem.
     * @return OrderItemDto.
     */
    OrderItemDto getById(Integer id);

    List<OrderItemDto> getAllByAmazonOrderId(String amazonOrderId);

	Grafo1dto getDateBetween(Instant inizio, Instant fine);

	List<Grafo2dto> getDateBetweenitem(Instant inizio, Instant fine);
}
