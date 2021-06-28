package its.kennedy.gestione.magazzino;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import its.kennedy.gestione.magazzino.Dto.OrderDto;
import its.kennedy.gestione.magazzino.Dto.OrderDto.OrdersDtoList;
import its.kennedy.gestione.magazzino.Dto.OrderItemDto;
import its.kennedy.gestione.magazzino.Service.OrdersService;

@Component
public class Task {
	@Autowired
	private OrdersService ordersService;

	@Scheduled(fixedRate = 86400000)
	public void ordertask() {
		URL url = null;
		try {
			url = new URL(
					"https://projectwork.gomulgame.com/WebServiceOrders.asmx/orders?refresh_token=Atzr%7CIwEBIPGGbogA4gJ86OciHsp16r6gXmV&CreatedAfter=2021-06-01T16:09:52.000&CreatedBefore=2021-07-31T16:09:52.000");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		HttpURLConnection connection = null;
		InputStream responseStream = null;
		OrdersDtoList apod = null;
		try {
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("accept", "application/json");
			responseStream = connection.getInputStream();
			ObjectMapper mapper = new ObjectMapper();
			mapper.findAndRegisterModules();
			apod = mapper.readValue(responseStream, OrderDto.OrdersDtoList.class);
			ordersService.addOrders(apod);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
