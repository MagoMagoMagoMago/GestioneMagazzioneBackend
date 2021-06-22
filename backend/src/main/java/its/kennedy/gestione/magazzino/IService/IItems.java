package its.kennedy.gestione.magazzino.IService;

import its.kennedy.gestione.magazzino.Dao.Item;
import its.kennedy.gestione.magazzino.Dto.BaseResponsePage;
import its.kennedy.gestione.magazzino.Dto.ItemsDto;


public interface IItems {
    public ItemsDto getById(Integer id);
    public Boolean modifica(Item entity);
    public BaseResponsePage<ItemsDto> selezionaPagina(int pagina, int quantita, String sortBy, Boolean dir);
    public Boolean deleteById(Integer id);
}
