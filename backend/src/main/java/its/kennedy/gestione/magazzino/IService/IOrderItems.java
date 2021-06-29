package its.kennedy.gestione.magazzino.IService;

import its.kennedy.gestione.magazzino.Dto.OrderItemDto;

import java.time.Instant;
import java.util.ArrayList;
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

	ArrayList<OrderItemDto> getDateBetween(Instant inizio, Instant fine);
}
