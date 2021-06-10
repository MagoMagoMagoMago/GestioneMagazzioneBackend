package its.kennedy.gestione.magazzino.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import its.kennedy.gestione.magazzino.Dao.ItemsDao;
import its.kennedy.gestione.magazzino.Dto.ItemsDto;
import its.kennedy.gestione.magazzino.IService.IItems;
import its.kennedy.gestione.magazzino.Repository.ItemsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
@Service
public class ItemsService implements IItems{
	@Autowired
	private ItemsRepository itemsRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public ItemsDto getById(Integer id) {
		return modelMapper.map(itemsRepository.getById(id),ItemsDto.class);
	}
	@Override
	public List<ItemsDto> selezionapagina(int pagina, int quantita,String sortBy,Boolean dir) {
		Pageable p;
		if(sortBy.length() <= 0)
			sortBy = "Id";
		if(dir==true)
			p = PageRequest.of(pagina, quantita, Sort.by(sortBy).ascending());
		else{
			p = PageRequest.of(pagina, quantita, Sort.by(sortBy).descending());
		}

		

		Page<ItemsDao> resP =itemsRepository.findAll(p);
		ArrayList<ItemsDto> res = new ArrayList<ItemsDto>();
		for(ItemsDao d : resP) {
			res.add(modelMapper.map(itemsRepository.getById(d.getId()),ItemsDto.class));
		}
		return res;
	}
}
