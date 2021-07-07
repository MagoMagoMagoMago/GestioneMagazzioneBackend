package its.kennedy.gestione.magazzino.IService;

import its.kennedy.gestione.magazzino.Dao.PurchaseItem;
import its.kennedy.gestione.magazzino.Dto.PurchaseItemDto;
import its.kennedy.gestione.magazzino.Dto.PurchaseItemDtoInsert;

import java.util.List;

public interface IPurchaseItems {

    PurchaseItemDto getById(Integer id);

    Boolean modifica(PurchaseItem entity);

    Boolean elimina(int id);
    
    List<PurchaseItemDto> getByPurchase(int id);

    Boolean addPurchases(List<PurchaseItemDtoInsert> purchaseItems);
}
