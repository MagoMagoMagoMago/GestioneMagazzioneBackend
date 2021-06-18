package its.kennedy.gestione.magazzino.Service;

import its.kennedy.gestione.magazzino.Dao.Purchases;
import its.kennedy.gestione.magazzino.Dto.BaseResponsePage;
import its.kennedy.gestione.magazzino.Dto.PurchasesDto;
import its.kennedy.gestione.magazzino.IService.IPurchases;
import its.kennedy.gestione.magazzino.Repository.PurchasesRepository;
import java.time.Instant;
import java.util.ArrayList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;

@Service
public class PurchasesService implements IPurchases {
    @Autowired
    private PurchasesRepository puchasesRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PurchasesDto getById(Integer id) {
        try {
            return modelMapper.map(puchasesRepository.findById(id).get(), PurchasesDto.class);
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public Boolean modifica(Purchases entity) {
        try {
            if (entity.getId() == null) {
                entity.setCreatedAt(Instant.now());
            } else {
                entity.setUpdatedAt(Instant.now());
            }
            puchasesRepository.saveAndFlush(entity);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean elimina(int id) {
    	try {
    		Purchases entity=puchasesRepository.findById(id).get();
    		entity.setDeletedAt(Instant.now());
    		puchasesRepository.saveAndFlush(entity);	
    	}catch(Exception e){
    		return false;
    	}
        return true;
    }
    @Override
    public BaseResponsePage<PurchasesDto> selezionaPagina(int pagina, int quantita, String sortBy, Boolean dir) {
        Pageable p;
        if (sortBy.length() <= 0) {
            sortBy = "Id";
        }
        if (dir == true) {
            p = PageRequest.of(pagina, quantita, Sort.by(sortBy).ascending());
        } else {
            p = PageRequest.of(pagina, quantita, Sort.by(sortBy).descending());
        }
        Page<Purchases> resP = puchasesRepository.findAllByDeletedAt(null, p);
        BaseResponsePage<PurchasesDto> baseResponsePage=new BaseResponsePage<PurchasesDto>();
        baseResponsePage.setPagine(resP.getTotalPages()); 
        ArrayList<PurchasesDto> res = new ArrayList<PurchasesDto>();
        for (Purchases d : resP) {
            res.add(modelMapper.map(d, PurchasesDto.class));
        }
        baseResponsePage.setList(res);
        return baseResponsePage;
    }
}
