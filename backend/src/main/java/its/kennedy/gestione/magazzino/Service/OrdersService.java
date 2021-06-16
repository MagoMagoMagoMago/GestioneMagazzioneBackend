package its.kennedy.gestione.magazzino.Service;

import its.kennedy.gestione.magazzino.Dao.Orders;
import its.kennedy.gestione.magazzino.Dto.OrdersDto;
import its.kennedy.gestione.magazzino.IService.IOrders;
import its.kennedy.gestione.magazzino.Repository.OrdersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    @Override
    public List<OrdersDto> selezionaPagina(int pagina, int quantita, String sortBy, Boolean dir) {
        Pageable p;
        if (sortBy.length() <= 0) {
            sortBy = "Id";
        }
        if (dir == true) {
            p = PageRequest.of(pagina, quantita, Sort.by(sortBy).ascending());
        } else {
            p = PageRequest.of(pagina, quantita, Sort.by(sortBy).descending());
        }


        Page<Orders> resP = ordersRepository.findAll(p);
        ArrayList<OrdersDto> res = new ArrayList<OrdersDto>();
        for (Orders d : resP) {
            res.add(modelMapper.map(ordersRepository.getById(d.getAmazonOrderId()), OrdersDto.class));
        }
        return res;
    }


}
