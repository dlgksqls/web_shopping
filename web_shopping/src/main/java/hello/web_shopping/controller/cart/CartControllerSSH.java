package hello.web_shopping.controller.cart;

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

@Controller
@RequestMapping("/cartssh")
@RequiredArgsConstructor
public class CartControllerSSH {

    private final CartService cartService;

    @GetMapping("/{memberId}")
    public String viewCart(Model model, @PathVariable String memberId){
        CartReturnDto dto = new CartReturnDto();
        cartService.findCartByMemberId(memberId);
        model.addAttribute()
    }
}
