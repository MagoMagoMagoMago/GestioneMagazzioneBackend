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
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemsService implements IItems {

    @Autowired
    private ItemsRepository itemsRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ItemDto getById(Integer id) {
        Item item = itemsRepository.getById(id);
        ItemDto itemDto = modelMapper.map(item, ItemDto.class);
        itemDto.setCategory(item.getCategory().getName());
        return itemDto;
    }

    @Override
    public Boolean addOrUpdate(Item item) {
        try {
            if (item.getId() == null) {
                item.setCreatedAt(Instant.now());
            } else {
                item.setUpdatedAt(Instant.now());
            }
            itemsRepository.saveAndFlush(item);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional()
    public BaseResponsePage<ItemDto> selezionaPagina(int pagina, int quantita, String sortBy, Boolean order, String title) {
        Pageable pageable;
        if (sortBy.length() <= 0) {
            sortBy = "Id";
        } else if (sortBy.equals("categoryId")) {
            sortBy += ".name";
        }
        if (order) {
            pageable = PageRequest.of(pagina, quantita, Sort.by(sortBy).ascending());
        } else {
            pageable = PageRequest.of(pagina, quantita, Sort.by(sortBy).descending());
        }
        Page<Item> itemPage;
        if (title == null) {
            itemPage = itemsRepository.findAllByDeletedAt(null, pageable);
        } else {
            itemPage = itemsRepository.findByDeletedAtAndTitleContainingIgnoreCase(null, title, pageable);
        }
        BaseResponsePage<ItemDto> baseResponsePage = new BaseResponsePage<ItemDto>();
        baseResponsePage.setPagine(itemPage.getTotalPages());
        ArrayList<ItemDto> res = new ArrayList<ItemDto>();
        for (Item d : itemPage) {
            ItemDto itemDto = modelMapper.map(d, ItemDto.class);
            itemDto.setCategory(d.getCategory().getName());
            res.add(itemDto);
        }
        baseResponsePage.setList(res);
        return baseResponsePage;
    }

    @Override
    public Boolean deleteById(Integer id) {
        try {
            Item entity = itemsRepository.findById(id).get();
            entity.setDeletedAt(Instant.now());
            itemsRepository.saveAndFlush(entity);
        } catch (Exception e) {
            return false;
        }
        return true;

    }

    @Override
    public Item getByAsin(String asin) {
        return itemsRepository.getByAsin(asin);
    }

    @Override
    public List<ItemDto> getBygiacenzainferiore() {
        ArrayList<ItemDto> res = new ArrayList<ItemDto>();
        List<Item> resP = itemsRepository.getBygiacenzainferiore();
        for (Item d : resP) {
            ItemDto itemDto = modelMapper.map(d, ItemDto.class);
            itemDto.setCategory(d.getCategory().getName());
            res.add(itemDto);
        }
        return res;
    }

}
