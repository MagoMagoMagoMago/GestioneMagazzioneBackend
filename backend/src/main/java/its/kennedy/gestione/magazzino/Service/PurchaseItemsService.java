package its.kennedy.gestione.magazzino.Service;

import its.kennedy.gestione.magazzino.Dao.Item;
import its.kennedy.gestione.magazzino.Dao.PurchaseItem;
import its.kennedy.gestione.magazzino.Dto.PurchaseItemDto;
import its.kennedy.gestione.magazzino.Dto.PurchaseItemDtoInsert;
import its.kennedy.gestione.magazzino.IService.IPurchaseItems;
import its.kennedy.gestione.magazzino.Repository.ItemsRepository;
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
    private ItemsRepository itemsRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PurchaseItemDto getById(Integer id) {
        PurchaseItem ent = puchasesRepository.findById(id).get();
        PurchaseItemDto dto = modelMapper.map(ent, PurchaseItemDto.class);
        dto.setItem(ent.getItem().getTitle());
        return dto;
    }

    @Override
    public List<PurchaseItemDto> getByPurchase(int id) {

        List<PurchaseItemDto> ritorno = new ArrayList<PurchaseItemDto>();
        List<PurchaseItem> iterable = puchasesRepository.findAllByPurchase_id(id);
        for (PurchaseItem i : iterable) {
            PurchaseItemDto t2 = modelMapper.map(i, PurchaseItemDto.class);
            t2.setItem(i.getItem().getTitle());
            ritorno.add(t2);
        }
        return ritorno;
    }

    @Override
    public Boolean addPurchases(List<PurchaseItemDtoInsert> purchaseItems) {
        for (PurchaseItemDtoInsert purchaseItem : purchaseItems) {
            try {
            	
                int modicag = purchaseItem.getQuantity();
                if (purchaseItem.getId() == null) {
                    purchaseItem.setCreated_at(Instant.now());
                    final PurchaseItem purchaseItemFinal = modelMapper.map(purchaseItem, PurchaseItem.class);
                    purchaseItemFinal.setItem(itemsRepository.getById(purchaseItem.getItem()));
                    puchasesRepository.saveAndFlush(purchaseItemFinal);
                    Item n = itemsRepository.getById(purchaseItemFinal.getItem().getId());
                    n.setStorage(n.getStorage() + modicag);
                    itemsRepository.saveAndFlush(n);
                }
            } catch (Exception e) {
            	System.out.println(e);
                return false;
            }
        }
        return true;
    }

    @Override
    public Boolean modifica(PurchaseItem entity) {
        try {
            int modicag = entity.getQuantity();
            if (entity.getId() == null) {
                entity.setCreated_at(Instant.now());
            } else {
                if (puchasesRepository.getById(entity.getId()).getCreated_at().plusMillis(864000000).isBefore(Instant.now())) {
                    return false;
                }
                entity.setUpdated_at(Instant.now());
                modicag -= puchasesRepository.getById(entity.getId()).getQuantity();
            }
            puchasesRepository.saveAndFlush(entity);
            Item n = itemsRepository.getById(entity.getItem().getId());
            n.setStorage(n.getStorage() + modicag);
            itemsRepository.saveAndFlush(n);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean elimina(int id) {
        try {
            PurchaseItem entity = puchasesRepository.findById(id).get();
            if (entity.getCreated_at().plusMillis(864000000).isBefore(Instant.now())) {
                return false;
            }
            Item item = itemsRepository.getById(entity.getItem().getId());
            item.setStorage(item.getStorage() - entity.getQuantity());
            itemsRepository.saveAndFlush(item);
            entity.setDeleted_at(Instant.now());
            puchasesRepository.saveAndFlush(entity);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
