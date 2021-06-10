package its.kennedy.gestione.magazzino.IService;

import its.kennedy.gestione.magazzino.Dto.ItemsDto;

import java.util.List;

public interface IItems {
    ItemsDto getById(Integer id);

    public List<ItemsDto> selezionaPagina(int pagina, int quantita, String sortBy, Boolean dir);
}
