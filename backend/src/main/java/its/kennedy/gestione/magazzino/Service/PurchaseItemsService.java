package its.kennedy.gestione.magazzino.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import its.kennedy.gestione.magazzino.Dao.PurchaseItems;
import its.kennedy.gestione.magazzino.Dto.PurchaseItemsDto;
import its.kennedy.gestione.magazzino.IService.IPurchaseItems;
import its.kennedy.gestione.magazzino.Repository.PurchaseItemsRepository;
@Service
public class PurchaseItemsService implements IPurchaseItems {
    @Autowired
    private PurchaseItemsRepository puchasesRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public PurchaseItemsDto getById(Integer id) {
        return modelMapper.map(puchasesRepository.findById(id).get(),PurchaseItemsDto.class);
    	}
    @Override
    public List<PurchaseItemsDto> getByPurchase(int id) {
    	
    	List<PurchaseItemsDto> ritorno=new ArrayList<PurchaseItemsDto>();
    	List<PurchaseItems>iterable=puchasesRepository.findAllByPurchase_id(id);
    	for (PurchaseItems i : iterable) {
    		ritorno.add(modelMapper.map(i,PurchaseItemsDto.class));
		}
        return ritorno;
    }
    @Override
    public Boolean modifica(PurchaseItems entity) {
    	try {
    		if(entity.getId()==null) {
    		entity.setCreated_at(Instant.now());
    		}else {
    	    entity.setUpdated_at(Instant.now());
    		}
    		puchasesRepository.saveAndFlush(entity);	
    	}catch(Exception e){
    		return false;
    	}
        return true;
    }
    
    @Override
    public Boolean elimina(int id) {
    	try {
    		PurchaseItems  entity=puchasesRepository.findById(id).get();
    		entity.setDeleted_at(Instant.now());
    		puchasesRepository.saveAndFlush(entity);	
    	}catch(Exception e){
    		return false;
    	}
        return true;
    }
}
