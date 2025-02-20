package hello.web_shopping.controller.cart;

import hello.web_shopping.dto.cart.CartItemReturnDto;
import hello.web_shopping.dto.cart.CartReturnDto;
import hello.web_shopping.entity.Cart;
import hello.web_shopping.service.cart.CartService;
import hello.web_shopping.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cartssh")
@RequiredArgsConstructor
public class CartControllerSSH {

    private final CartService cartService;

    @GetMapping("/{memberId}")
    public String viewCart(Model model, @PathVariable String memberId){
        List<CartItemReturnDto> cartItems = cartService.findCartByMemberId(memberId);

        Long totalPrice = 0L;
        int quantity = 0;

        for (CartItemReturnDto cartItem : cartItems) {
            totalPrice += cartItem.getPrice() * cartItem.getQuantity();
            quantity += cartItem.getQuantity();
        }
        model.addAttribute("items", cartItems);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("quantity", quantity);

        return "cart/viewMemberCart";
    }
}
