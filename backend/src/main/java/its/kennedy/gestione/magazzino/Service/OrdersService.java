package its.kennedy.gestione.magazzino.Service;

import its.kennedy.gestione.magazzino.Dao.Order;
import its.kennedy.gestione.magazzino.Dto.OrderDto;
import its.kennedy.gestione.magazzino.IService.IOrders;
import its.kennedy.gestione.magazzino.Repository.OrdersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService implements IOrders {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrderDto getById(String id) {
        return modelMapper.map(ordersRepository.findById(id), OrderDto.class);
    }

    @Override
    public Boolean addOrders(OrderDto.OrdersDtoList orders) {
        List<Order> newOrders = new ArrayList<>();
        List<String> myAmazonOrdersIds = ordersRepository.findAllIds();
        orders.getOrders().forEach(order -> {
            if (!myAmazonOrdersIds.contains(order.getAmazonOrderId())) {
                newOrders.add(modelMapper.map(order, Order.class));
            }
        });
        try {
            ordersRepository.saveAll(newOrders);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<OrderDto> selezionaPagina(int pagina, int quantita, String sortBy, Boolean dir) {
        Pageable p;
        if (sortBy.length() <= 0) {
            sortBy = "Id";
        }
        if (dir == true) {
            p = PageRequest.of(pagina, quantita, Sort.by(sortBy).ascending());
        } else {
            p = PageRequest.of(pagina, quantita, Sort.by(sortBy).descending());
        }

        Page<Order> resP = ordersRepository.findAll(p);
        ArrayList<OrderDto> res = new ArrayList<OrderDto>();
        for (Order d : resP) {
            res.add(modelMapper.map(ordersRepository.getById(d.getAmazonOrderId()), OrderDto.class));
        }
        return res;
    }

    @Override
    public List<String> getAllAmazonOrderId() {
        return ordersRepository.findAllIds();
    }


}
