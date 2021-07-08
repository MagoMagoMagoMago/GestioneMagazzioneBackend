package its.kennedy.gestione.magazzino.IService;

import its.kennedy.gestione.magazzino.Dto.Grafo1dto;
import its.kennedy.gestione.magazzino.Dto.Grafo2dto;
import its.kennedy.gestione.magazzino.Dto.OrderItemDto;
import its.kennedy.gestione.magazzino.Dto.grafo3;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
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

	List<grafo3> getDateBetweencategorie(Instant inizio, Instant fine);
}
