package its.kennedy.gestione.magazzino.IService;

import its.kennedy.gestione.magazzino.Dao.Items;
import its.kennedy.gestione.magazzino.Dto.BaseResponsePage;
import its.kennedy.gestione.magazzino.Dto.ItemsDto;

import java.util.List;

public interface IItems {
    public ItemsDto getById(Integer id);
    public Boolean modifica(Items entity);
    public BaseResponsePage<ItemsDto> selezionaPagina(int pagina, int quantita, String sortBy, Boolean dir);
    public Boolean deleteById(Integer id);
}
