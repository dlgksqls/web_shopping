package hello.web_shopping.controller.order;

import hello.web_shopping.dto.order.OrderInputDto;
import hello.web_shopping.dto.order.OrderReturnDto;
import hello.web_shopping.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderControllerImpl implements OrderController{

    private final OrderService orderService;

    @Override
    @PostMapping("")
    public ResponseEntity<OrderReturnDto> order(OrderInputDto dto, String request) {
        OrderReturnDto newOrder = orderService.order(dto.getMemberId(), request);

        return new ResponseEntity<>(newOrder, HttpStatus.ACCEPTED);
    }

    @Override
    @PostMapping("cancel")
    public ResponseEntity<String> orderCancel(Long orderId) {
        orderService.orderCancel(orderId);

        return new ResponseEntity<>("cancel 성공", HttpStatus.ACCEPTED);
    }
}
