package its.kennedy.gestione.magazzino.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import its.kennedy.gestione.magazzino.Dao.Item;
import its.kennedy.gestione.magazzino.Dao.Order;
import its.kennedy.gestione.magazzino.Dao.OrderItem;
import its.kennedy.gestione.magazzino.Dto.BaseResponsePage;
import its.kennedy.gestione.magazzino.Dto.OrderDto;
import its.kennedy.gestione.magazzino.Dto.OrderItemDto;
import its.kennedy.gestione.magazzino.IService.IOrders;
import its.kennedy.gestione.magazzino.Repository.OrderItemsRepository;
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
    private OrderItemsRepository orderItemsRepository;

    @Autowired
    private ItemsService itemsService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrderDto getById(String id) {
        return modelMapper.map(ordersRepository.findById(id), OrderDto.class);
    }

    @Override
    public Boolean addOrders(OrderDto.OrdersDtoList orders) {
        List<String> myAmazonOrdersIds = ordersRepository.findAllIds();
        for (OrderDto order : orders.getOrders()) {
            if (!myAmazonOrdersIds.contains(order.getAmazonOrderId())) {

                OrderItemDto.OrderItemDtoList orderItemDtoList = getItemsOfOrder(order.getAmazonOrderId());
                for (OrderItemDto orderItemDto : orderItemDtoList.getOrderItems()) {
                    Item item = itemsService.getByAsin(orderItemDto.getAsin());
                    try {
                        if (item.getStorage() < orderItemDto.getQuantityOrdered()) {
                            order.setOrderSuccess(false);
                            orderItemDto.setOrderSuccess(false);
                        } else {
                            order.setOrderSuccess(true);
                            orderItemDto.setOrderSuccess(true);
                            item.setStorage(item.getStorage() - orderItemDto.getQuantityOrdered());
                            itemsService.addOrUpdate(item);
                        }
                        ordersRepository.save(modelMapper.map(order, Order.class));
                        orderItemsRepository.save(modelMapper.map(orderItemDto, OrderItem.class));
                    } catch (Exception e) {
                        //return false;
                    }
                }

            }
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

    public OrderItemDto.OrderItemDtoList getItemsOfOrder(String idOrdine) {
        URL url = null;
        try {
            url = new URL(
                    "https://projectwork.gomulgame.com/WebServiceOrders.asmx/orderitems?refresh_token=Atzr|IwEBIPGGbogA4gJ86OciHsp16r6gXmV&AmazonOrderId="
                            + idOrdine);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection connection;
        InputStream responseStream;
        OrderItemDto.OrderItemDtoList orderItemDtoList = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            responseStream = connection.getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            orderItemDtoList = mapper.readValue(responseStream, OrderItemDto.OrderItemDtoList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orderItemDtoList;
    }

}
