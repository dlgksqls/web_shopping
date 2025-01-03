package hello.web_shopping.controller.order;

import hello.web_shopping.dto.order.OrderInputDto;
import hello.web_shopping.dto.order.OrderReturnDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/order")
public interface OrderController {

    public ResponseEntity<OrderReturnDto> order(OrderInputDto dto, String request);
}
