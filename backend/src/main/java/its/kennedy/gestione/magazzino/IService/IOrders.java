package its.kennedy.gestione.magazzino.IService;

import its.kennedy.gestione.magazzino.Dto.OrdersDto;

import java.util.List;

public interface IOrders {

    /**
     * Get order by Id.
     *
     * @param id of Order.
     * @return OrdersDto.
     */
    OrdersDto getById(Integer id);

    /**
     * Inserts a list of orders.
     *
     * @param orders list of orders
     * @return True if the orders were inserted correctly, false otherwise
     */
    Boolean addOrders(List<OrdersDto> orders);

}
