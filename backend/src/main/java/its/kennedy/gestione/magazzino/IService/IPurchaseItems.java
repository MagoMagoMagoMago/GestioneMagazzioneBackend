package its.kennedy.gestione.magazzino.IService;

import its.kennedy.gestione.magazzino.Dao.PurchaseItem;
import its.kennedy.gestione.magazzino.Dto.PurchaseItemsDto;

import java.util.List;

public interface IPurchaseItems {

    PurchaseItemsDto getById(Integer id);

    Boolean modifica(PurchaseItem entity);

    Boolean elimina(int id);


    List<PurchaseItemsDto> getByPurchase(int id);

}
