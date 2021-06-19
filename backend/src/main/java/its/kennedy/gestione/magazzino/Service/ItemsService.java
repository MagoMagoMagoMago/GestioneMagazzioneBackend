package its.kennedy.gestione.magazzino.Service;

import its.kennedy.gestione.magazzino.Dao.Item;
import its.kennedy.gestione.magazzino.Dto.BaseResponsePage;
import its.kennedy.gestione.magazzino.Dto.ItemDto;
import its.kennedy.gestione.magazzino.IService.IItems;
import its.kennedy.gestione.magazzino.Repository.ItemsRepository;
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
public class ItemsService implements IItems {
    @Autowired
    private ItemsRepository itemsRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ItemDto getById(Integer id) {
        return modelMapper.map(itemsRepository.getById(id), ItemDto.class);
    }

    @Override
    public Boolean modifica(Item entity) {
        try {
            if (entity.getId() == null) {
                entity.setCreatedAt(Instant.now());
            } else {
                entity.setUpdatedAt(Instant.now());
            }
            itemsRepository.saveAndFlush(entity);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public BaseResponsePage<ItemDto> selezionaPagina(int pagina, int quantita, String sortBy, Boolean dir) {
        Pageable p;
        if (sortBy.length() <= 0) {
            sortBy = "Id";
        }
        if (dir == true) {
            p = PageRequest.of(pagina, quantita, Sort.by(sortBy).ascending());
        } else {
            p = PageRequest.of(pagina, quantita, Sort.by(sortBy).descending());
        }
        Page<Item> resP = itemsRepository.findAll(p);
        BaseResponsePage<ItemDto> baseResponsePage = new BaseResponsePage<ItemDto>();
        baseResponsePage.setPagine(resP.getTotalPages());
        ArrayList<ItemDto> res = new ArrayList<ItemDto>();
        for (Item d : resP) {
            ItemDto item = modelMapper.map(d, ItemDto.class);
            item.setCategory(d.getCategory().getName());
            res.add(item);
        }
        baseResponsePage.setList(res);
        return baseResponsePage;
    }
}
