package its.kennedy.gestione.magazzino.IService;

import its.kennedy.gestione.magazzino.Dto.OrderItemDto;

public interface IOrderItems {

    /**
     * Get orderItem by Id.
     *
     * @param id of orderItem.
     * @return OrderItemDto.
     */
    OrderItemDto getById(Integer id);
}
