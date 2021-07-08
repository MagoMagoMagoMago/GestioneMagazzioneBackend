package its.kennedy.gestione.magazzino.IService;

import its.kennedy.gestione.magazzino.Dto.BaseResponsePage;
import its.kennedy.gestione.magazzino.Dto.OrderDto;

import java.util.List;

public interface IOrders {

    /**
     * Get order by Id.
     *
     * @param id of Order.
     * @return OrderDto.
     */
    OrderDto getById(String id);

    /**
     * Inserts a list of orders.
     *
     * @param orders list of orders
     * @return True if the orders were inserted correctly, false otherwise
     */
    Boolean addOrders(OrderDto.OrdersDtoList orders);

    /**
     * Get a list of paginated order
     *
     * @param pagina   the number of the page to retrive
     * @param quantita
     * @param sortBy
     * @param dir
     * @return
     */
    BaseResponsePage<OrderDto> selezionaPagina(int pagina, int quantita, String sortBy, Boolean dir);

    List<String> getAllAmazonOrderId();
}
