package its.kennedy.gestione.magazzino.IService;

import its.kennedy.gestione.magazzino.Dao.Purchase;
import its.kennedy.gestione.magazzino.Dto.BaseResponsePage;
import its.kennedy.gestione.magazzino.Dto.PurchaseDto;

public interface IPurchases {
    PurchaseDto getById(Integer id);

    BaseResponsePage<PurchaseDto> selezionaPagina(int pagina, int quantita, String sortBy, Boolean dir);

    Boolean modifica(Purchase entity);

    Boolean elimina(int id);
    
    Integer insert(Purchase entity);
}
