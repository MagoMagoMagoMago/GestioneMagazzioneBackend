package its.kennedy.gestione.magazzino.Service;

import its.kennedy.gestione.magazzino.Dao.Items;
import its.kennedy.gestione.magazzino.Dto.BaseResponsePage;
import its.kennedy.gestione.magazzino.Dto.ItemsDto;
import its.kennedy.gestione.magazzino.IService.IItems;
import its.kennedy.gestione.magazzino.Repository.ItemsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;

@Service
public class ItemsService implements IItems {
    @Autowired
    private ItemsRepository itemsRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ItemsDto getById(Integer id) {
        return modelMapper.map(itemsRepository.getById(id), ItemsDto.class);
    }
    @Override
    public Boolean modifica(Items entity) {
    	try {
    		if(entity.getId()==null) {
    		entity.setCreatedAt(Instant.now());
    		}else {
    	    entity.setUpdatedAt(Instant.now());
    		}
    		itemsRepository.saveAndFlush(entity);	
    	}catch(Exception e){
    		return false;
    	}
        return true;
    }
    
    @Override
    @Transactional()
    public BaseResponsePage<ItemsDto> selezionaPagina(int pagina, int quantita, String sortBy, Boolean order) {
        Pageable p;
        if (sortBy.length() <= 0) {
            sortBy = "Id";
        }
        if (order == true) {
            p = PageRequest.of(pagina, quantita, Sort.by(sortBy).ascending());
        } else {
            p = PageRequest.of(pagina, quantita, Sort.by(sortBy).descending());
        }
        Page<Items> resP = itemsRepository.findAll(p);
        BaseResponsePage<ItemsDto> baseResponsePage=new BaseResponsePage<ItemsDto>();
        baseResponsePage.setPagine(resP.getTotalPages()); 
        ArrayList<ItemsDto> res = new ArrayList<ItemsDto>();
        for (Items d : resP) {
            res.add(modelMapper.map(itemsRepository.getById(d.getId()), ItemsDto.class));
        }
        baseResponsePage.setList(res);
        return baseResponsePage;
    }

    @Override
    public Boolean deleteById(Integer id) {
        try {
            itemsRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
