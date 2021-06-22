package its.kennedy.gestione.magazzino.Service;

import its.kennedy.gestione.magazzino.Dao.PurchaseItem;
import its.kennedy.gestione.magazzino.Dto.PurchaseItemDto;
import its.kennedy.gestione.magazzino.IService.IPurchaseItems;
import its.kennedy.gestione.magazzino.Repository.PurchaseItemsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseItemsService implements IPurchaseItems {
    @Autowired
    private PurchaseItemsRepository puchasesRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PurchaseItemDto getById(Integer id) {
        return modelMapper.map(puchasesRepository.findById(id).get(), PurchaseItemDto.class);
    }

    @Override
    public List<PurchaseItemDto> getByPurchase(int id) {

        List<PurchaseItemDto> ritorno = new ArrayList<PurchaseItemDto>();
        List<PurchaseItem> iterable = puchasesRepository.findAllByPurchase_id(id);
        for (PurchaseItem i : iterable) {
            ritorno.add(modelMapper.map(i, PurchaseItemDto.class));
        }
        return ritorno;
    }

    @Override
    public Boolean modifica(PurchaseItem entity) {
        try {
            if (entity.getId() == null) {
                entity.setCreated_at(Instant.now());
            } else {
                entity.setUpdated_at(Instant.now());
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
            PurchaseItem entity = puchasesRepository.findById(id).get();
            entity.setDeleted_at(Instant.now());
            puchasesRepository.saveAndFlush(entity);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
