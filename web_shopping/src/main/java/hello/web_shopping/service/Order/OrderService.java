package hello.web_shopping.service.Order;

import hello.web_shopping.dto.order.OrderInputDto;
import hello.web_shopping.dto.order.OrderReturnDto;
import hello.web_shopping.entity.Order;

public interface OrderService {

    OrderReturnDto order(String memberId, String request);
    void orderCancel(Long orderId);
}
