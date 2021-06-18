package its.kennedy.gestione.magazzino.IService;

import its.kennedy.gestione.magazzino.Dao.Purchases;
import its.kennedy.gestione.magazzino.Dto.BaseResponsePage;
import its.kennedy.gestione.magazzino.Dto.PurchasesDto;

public interface IPurchases {
    PurchasesDto getById(Integer id);
	BaseResponsePage<PurchasesDto> selezionaPagina(int pagina, int quantita, String sortBy, Boolean dir);
	Boolean modifica(Purchases entity);
	Boolean elimina(int id);
}
