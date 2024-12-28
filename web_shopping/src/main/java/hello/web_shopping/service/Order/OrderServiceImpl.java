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

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final MemberRepository memberRepository;

    @Override
    public OrderReturnDto order(Long cartId, String memberId, String request) {
        Cart orderCart = cartRepository.findByCartId(cartId);
        Member orderMember = memberRepository.findByLoginId(memberId);

        if (orderCart.getMember().getLoginId() != orderMember.getLoginId()){
            return null;
        }

        Order newOrder = new Order();
        newOrder.createOrder(orderCart, request);

        orderRepository.save(newOrder);
        cartRepository.delete(orderCart);

        Long totalPrice = newOrder.getOrderPrice();

        return new OrderReturnDto(totalPrice);
    }
}
