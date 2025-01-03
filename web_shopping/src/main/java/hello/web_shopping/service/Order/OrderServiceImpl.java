package hello.web_shopping.service.Order;

import hello.web_shopping.dto.order.OrderInputDto;
import hello.web_shopping.dto.order.OrderReturnDto;
import hello.web_shopping.entity.Cart;
import hello.web_shopping.entity.Member;
import hello.web_shopping.entity.Order;
import hello.web_shopping.repository.CartRepository;
import hello.web_shopping.repository.MemberRepository;
import hello.web_shopping.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final MemberRepository memberRepository;

    @Override
    public OrderReturnDto order(String memberId, String request) {
        Member orderMember = memberRepository.findByLoginId(memberId);
        List<Cart> orderCarts = cartRepository.findCartByMember(orderMember.getId());

        if (orderCarts == null || orderMember == null){
            return null;
        }

        Order newOrder = new Order();
        newOrder.createOrder(orderCarts, request);

        orderRepository.save(newOrder);

        for (Cart orderCart : orderCarts) {
            cartRepository.delete(orderCart);
        }

        Long totalPrice = newOrder.getOrderPrice();

        return new OrderReturnDto(totalPrice, orderCarts);
    }
}
