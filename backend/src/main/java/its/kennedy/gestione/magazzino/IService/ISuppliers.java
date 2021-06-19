package its.kennedy.gestione.magazzino.IService;

import its.kennedy.gestione.magazzino.Dao.Supplier;
import its.kennedy.gestione.magazzino.Dto.SuppliersDto;

import java.util.List;

public interface ISuppliers {
    SuppliersDto getById(Integer id);

    Boolean modifica(Supplier entity);

    List<SuppliersDto> getAll();

}
