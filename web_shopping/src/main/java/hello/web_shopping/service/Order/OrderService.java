package hello.web_shopping.service.Order;

import hello.web_shopping.dto.order.OrderInputDto;
import hello.web_shopping.dto.order.OrderReturnDto;

public interface OrderService {

    OrderReturnDto order(String memberId, String request);
}
