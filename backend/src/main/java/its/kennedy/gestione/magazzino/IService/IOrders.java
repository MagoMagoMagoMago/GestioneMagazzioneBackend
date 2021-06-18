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
    OrdersDto getById(String id);

    /**
     * Inserts a list of orders.
     *
     * @param orders list of orders
     * @return True if the orders were inserted correctly, false otherwise
     */
    Boolean addOrders(OrdersDto.OrdersDtoList orders);

    /**
     * Get a list of paginated orders
     *
     * @param pagina   the number of the page to retrive
     * @param quantita
     * @param sortBy
     * @param dir
     * @return
     */
    List<OrdersDto> selezionaPagina(int pagina, int quantita, String sortBy, Boolean dir);

    List<String> getAllAmazonOrderId();
}
