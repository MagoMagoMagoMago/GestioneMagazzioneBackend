package its.kennedy.gestione.magazzino.IService;

import its.kennedy.gestione.magazzino.Dao.Item;
import its.kennedy.gestione.magazzino.Dto.BaseResponsePage;
import its.kennedy.gestione.magazzino.Dto.ItemDto;

public interface IItems {
    public ItemDto getById(Integer id);

    public Boolean modifica(Item entity);

    public BaseResponsePage<ItemDto> selezionaPagina(int pagina, int quantita, String sortBy, Boolean dir);
}
