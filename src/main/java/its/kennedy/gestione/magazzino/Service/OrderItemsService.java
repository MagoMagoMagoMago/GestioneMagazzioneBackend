package its.kennedy.gestione.magazzino.Service;

import its.kennedy.gestione.magazzino.Dao.OrderItem;
import its.kennedy.gestione.magazzino.Dto.Grafo1dto;
import its.kennedy.gestione.magazzino.Dto.Grafo2dto;
import its.kennedy.gestione.magazzino.Dto.OrderItemDto;
import its.kennedy.gestione.magazzino.Dto.grafo3;
import its.kennedy.gestione.magazzino.IService.IOrderItems;
import its.kennedy.gestione.magazzino.Repository.ItemsRepository;
import its.kennedy.gestione.magazzino.Repository.OrderItemsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemsService implements IOrderItems {

	@Autowired
	private OrderItemsRepository orderItemsRepository;

	@Autowired
	private ItemsRepository itemsRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public OrderItemDto getById(Integer id) {
		return modelMapper.map(orderItemsRepository.findById(id), OrderItemDto.class);
	}

	@Override
	public Grafo1dto getDateBetween(Instant inizio, Instant fine) {
		Grafo1dto u = orderItemsRepository.getDateBetween(inizio, fine);
		return u;
	}

	@Override
	public List<Grafo2dto> getDateBetweenitem(Instant inizio, Instant fine) {
		try {
			List<Grafo2dto> u = orderItemsRepository.getDateBetweenitem(inizio, fine);
			for (Grafo2dto grafo2dto : u) {
				grafo2dto.setAsin(itemsRepository.getByAsin(grafo2dto.getAsin()).getTitle());
			}
			return u;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<grafo3> getDateBetweencategorie(Instant inizio, Instant fine) {
		try {
            List<Grafo2dto> u = orderItemsRepository.getDateBetweenitem(inizio, fine);
			List<grafo3> ris = new ArrayList<grafo3>();
			for (Grafo2dto grafo2dto : u) {
				String categoria = itemsRepository.getByAsin(grafo2dto.getAsin()).getCategory().getName();
				boolean trovato = false;
				for (grafo3 gra : ris) {
					if (gra.getCategoria().equals(categoria)) {
						gra.setGuadagno(gra.getGuadagno()+grafo2dto.getGuadagno());
						gra.setQuantita(gra.getQuantita()+grafo2dto.getQuantita());
						trovato = true;
					}
				}
				if(!trovato) { 
					ris.add(new grafo3(grafo2dto.getGuadagno(),grafo2dto.getQuantita(),categoria));
				}
			}
			return ris;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<OrderItemDto> getAllByAmazonOrderId(String amazonOrderId) {
		List<OrderItemDto> orderItemDtoList = new ArrayList<>();
		for (OrderItem orderItem : orderItemsRepository.getAllByAmazonOrderId(amazonOrderId)) {
			orderItemDtoList.add(modelMapper.map(orderItem, OrderItemDto.class));
		}
		return orderItemDtoList;
	}

	public Grafo1dto getDateBetween(Instant inizio, Instant fine, String asin) {
		Grafo1dto u = orderItemsRepository.getDateBetweensingle(inizio, fine,asin);
		return u;
	}

}
