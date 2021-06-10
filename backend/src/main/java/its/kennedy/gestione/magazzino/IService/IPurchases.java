package its.kennedy.gestione.magazzino.IService;

import its.kennedy.gestione.magazzino.Dto.OrdersDto;

public interface IPurchases {

    /**
     * Get purchases by Id.
     *
     * @param id of purchases.
     * @return UserDto.
     */
    OrdersDto getById(Integer id);
}
