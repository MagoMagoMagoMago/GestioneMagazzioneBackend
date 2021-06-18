package its.kennedy.gestione.magazzino.IService;

import java.util.List;

import its.kennedy.gestione.magazzino.Dao.PurchaseItems;
import its.kennedy.gestione.magazzino.Dto.PurchaseItemsDto;

public interface IPurchaseItems {

	PurchaseItemsDto getById(Integer id);

	Boolean modifica(PurchaseItems entity);

	Boolean elimina(int id);


	List<PurchaseItemsDto> getByPurchase(int id);

}
