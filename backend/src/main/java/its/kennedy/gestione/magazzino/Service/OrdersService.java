package its.kennedy.gestione.magazzino.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import its.kennedy.gestione.magazzino.Dao.Order;
import its.kennedy.gestione.magazzino.Dto.BaseResponsePage;
import its.kennedy.gestione.magazzino.Dto.OrderDto;
import its.kennedy.gestione.magazzino.Dto.OrderItemDto;
import its.kennedy.gestione.magazzino.IService.IOrders;
import its.kennedy.gestione.magazzino.Repository.OrdersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
    public BaseResponsePage<OrderDto> selezionaPagina(int pagina, int quantita, String sortBy, Boolean order) {
        Pageable p;
        if (sortBy.length() <= 0) {
            sortBy = "Id";
        }
        if (order) {
            p = PageRequest.of(pagina, quantita, Sort.by(sortBy).ascending());
        } else {
            p = PageRequest.of(pagina, quantita, Sort.by(sortBy).descending());
        }
        Page<Order> resP = ordersRepository.findAll(p);
        BaseResponsePage<OrderDto> baseResponsePage = new BaseResponsePage<>();
        baseResponsePage.setPagine(resP.getTotalPages());
        ArrayList<OrderDto> res = new ArrayList<OrderDto>();
        for (Order orderObject : resP) {
            res.add(modelMapper.map(orderObject, OrderDto.class));
        }
        baseResponsePage.setList(res);
        return baseResponsePage;
    }

    @Override
    public List<String> getAllAmazonOrderId() {
        return ordersRepository.findAllIds();
    }


}
