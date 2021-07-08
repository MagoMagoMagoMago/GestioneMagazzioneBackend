package its.kennedy.gestione.magazzino.IService;

import its.kennedy.gestione.magazzino.Dto.SupplierDto;
import its.kennedy.gestione.magazzino.Dto.SupplierUpdateDto;

import java.util.List;

public interface ISuppliers {
    SupplierDto getById(Integer id);

    Boolean modifica(SupplierUpdateDto entity);

	Boolean elimina(int id);

	List<SupplierDto> getAll(String sortBy, Boolean order);

}
