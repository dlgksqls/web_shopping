package hello.web_shopping.controller.cart;

import hello.web_shopping.dto.cart.CartReturnDto;
import hello.web_shopping.dto.cart.ItemAddToCartDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cart")
public interface CartController {

    ResponseEntity<CartReturnDto> addItemToCart(ItemAddToCartDto itemAddToCartDto);
}
