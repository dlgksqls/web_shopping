package hello.web_shopping.controller.cart;

import hello.web_shopping.dto.cart.CartReturnDto;
import hello.web_shopping.dto.cart.ItemAddToCartDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cart")
public interface CartControllerAPI {

    ResponseEntity<CartReturnDto> addItemToCart(ItemAddToCartDto itemAddToCartDto);

    ResponseEntity<CartReturnDto> removeItemFromCart(String memberId, String itemId, int removeQuantity);
}
