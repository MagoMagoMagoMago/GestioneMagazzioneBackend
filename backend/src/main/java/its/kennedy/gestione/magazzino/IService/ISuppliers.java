package its.kennedy.gestione.magazzino.IService;

import its.kennedy.gestione.magazzino.Dao.Supplier;
import its.kennedy.gestione.magazzino.Dto.SupplierDto;

import java.util.List;

public interface ISuppliers {
    SupplierDto getById(Integer id);

    Boolean modifica(Supplier entity);

    List<SupplierDto> getAll();

}
