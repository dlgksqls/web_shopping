package hello.web_shopping.service.order;

import hello.web_shopping.dto.order.OrderReturnDto;

public interface OrderService {

    OrderReturnDto order(String memberId, String request);
    void orderCancel(Long orderId);
}
