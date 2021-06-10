package its.kennedy.gestione.magazzino.IService;

import java.util.List;

import its.kennedy.gestione.magazzino.Dto.ItemsDto;

public interface IItems {
 ItemsDto getById(Integer id);
 public List<ItemsDto> selezionapagina(int pagina, int quantita,String sortBy,Boolean dir);
}
