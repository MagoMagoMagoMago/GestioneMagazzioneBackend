package its.kennedy.gestione.magazzino.Service;

import its.kennedy.gestione.magazzino.Dao.OrderItem;
import its.kennedy.gestione.magazzino.Dto.OrderItemDto;
import its.kennedy.gestione.magazzino.IService.IOrderItems;
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
    private ModelMapper modelMapper;

    @Override
    public OrderItemDto getById(Integer id) {
        return modelMapper.map(orderItemsRepository.findById(id), OrderItemDto.class);
    }
    @Override
	public ArrayList<OrderItemDto> getDateBetween(Instant inizio, Instant fine) {
		List<OrderItem> t = orderItemsRepository.getDateBetween(inizio, fine);
		ArrayList<OrderItemDto> res = new ArrayList<OrderItemDto>();
		 for (OrderItem orderObject : t) {
				res.add(modelMapper.map(orderObject, OrderItemDto.class));
	        }
		return res;
	}
    @Override
    public List<OrderItemDto> getAllByAmazonOrderId(String amazonOrderId) {
        List<OrderItemDto> orderItemDtoList = new ArrayList<>();
        for (OrderItem orderItem : orderItemsRepository.getAllByAmazonOrderId(amazonOrderId)) {
            orderItemDtoList.add(modelMapper.map(orderItem, OrderItemDto.class));
        }
        return orderItemDtoList;
    }
}
