package hello.web_shopping.controller.order;

import hello.web_shopping.dto.order.OrderInputDto;
import hello.web_shopping.dto.order.OrderReturnDto;
import hello.web_shopping.service.Order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerImpl implements OrderController{

    private OrderService orderService;

    @Override
    public ResponseEntity<OrderReturnDto> order(OrderInputDto dto) {
        orderService.order(dto.getCartId(), dto.getMemberId());
    }
}
