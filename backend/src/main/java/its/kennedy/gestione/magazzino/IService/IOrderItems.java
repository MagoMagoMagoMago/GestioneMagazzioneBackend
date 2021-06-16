package its.kennedy.gestione.magazzino.IService;

import its.kennedy.gestione.magazzino.Dto.OrderItemsDto;

public interface IOrderItems {

    /**
     * Get orderItem by Id.
     *
     * @param id of orderItem.
     * @return OrderItemsDto.
     */
    OrderItemsDto getById(Integer id);
}
