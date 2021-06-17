package its.kennedy.gestione.magazzino.IService;

import java.util.List;

import its.kennedy.gestione.magazzino.Dao.Suppliers;
import its.kennedy.gestione.magazzino.Dto.SuppliersDto;

public interface ISuppliers {
	SuppliersDto getById(Integer id);
	Boolean modifica(Suppliers entity);
	List<SuppliersDto> getAll();

}
