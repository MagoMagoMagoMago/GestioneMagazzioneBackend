package its.kennedy.gestione.magazzino.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import its.kennedy.gestione.magazzino.Dao.Suppliers;
import its.kennedy.gestione.magazzino.Dto.SuppliersDto;
import its.kennedy.gestione.magazzino.IService.ISuppliers;
import its.kennedy.gestione.magazzino.Repository.SuppliersRepository;
  @Service
public class SuppliersService implements ISuppliers{
	@Autowired
	SuppliersRepository suppliersRepository;
	@Autowired
    private ModelMapper modelMapper;
	@Override
    public SuppliersDto getById(Integer id) {
        return modelMapper.map(suppliersRepository.getById(id), SuppliersDto.class);
    }
    @Override
    public Boolean modifica(Suppliers entity) {
    	try {
    		if(entity.getId()==null) {
    		entity.setCreatedAt(Instant.now());
    		}else {
    	    entity.setUpdatedAt(Instant.now());
    		}
    		suppliersRepository.saveAndFlush(entity);	
    	}catch(Exception e){
    		return false;
    	}
        return true;
    }
    
    @Override
    public List<SuppliersDto> getAll() {
    	
    	List<SuppliersDto> ritorno=new ArrayList<SuppliersDto>();
    	List<Suppliers>iterable=suppliersRepository.findAll();
    	for (Suppliers i : iterable) {
    		ritorno.add(modelMapper.map(i,SuppliersDto.class));
		}
        return ritorno;
    }
}
