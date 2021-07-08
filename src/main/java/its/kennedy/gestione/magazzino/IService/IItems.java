package its.kennedy.gestione.magazzino.IService;

import its.kennedy.gestione.magazzino.Dao.Item;
import its.kennedy.gestione.magazzino.Dto.BaseResponsePage;
import its.kennedy.gestione.magazzino.Dto.ItemDto;

import java.util.List;

public interface IItems {

    /**
     * Get ItemDto by Id.
     *
     * @param id of ItemDto.
     * @return an ItemDto.
     */
    public ItemDto getById(Integer id);

    /**
     * Modifies the Item with id of the item passed if the id is null it inserts the item instead
     *
     * @param item the Item to save
     * @return true if the operation is successful, false otherwise
     */
    public Boolean addOrUpdate(Item item);

    /**
     * @param pagina
     * @param quantita
     * @param sortBy
     * @param dir
     * @return
     */
    public BaseResponsePage<ItemDto> selezionaPagina(int pagina, int quantita, String sortBy, Boolean dir, String title);

    public Boolean deleteById(Integer id);

    public Item getByAsin(String asin);

    List<ItemDto> getBygiacenzainferiore();

}
