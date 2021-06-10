package its.kennedy.gestione.magazzino.Service;

import its.kennedy.gestione.magazzino.Dao.Orders;
import its.kennedy.gestione.magazzino.Dto.OrdersDto;
import its.kennedy.gestione.magazzino.IService.IOrders;
import its.kennedy.gestione.magazzino.Repository.OrdersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class OrdersService implements IOrders {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrdersDto getById(Integer id) {
        return modelMapper.map(ordersRepository.findById(id), OrdersDto.class);
    }

    @Override
    public Boolean addOrders(List<OrdersDto> orders) {
        List<Orders> ordersDao = new ArrayList<>();
        orders.forEach(o -> {
            ordersDao.add(modelMapper.map(o, Orders.class));
        });
        if (ordersRepository.saveAll(ordersDao).size() == orders.size()) {
            return true;
        }
        return false;
    }


}
