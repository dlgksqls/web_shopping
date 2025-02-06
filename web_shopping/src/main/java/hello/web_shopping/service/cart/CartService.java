package hello.web_shopping.service.cart;

import hello.web_shopping.dto.cart.CartItemReturnDto;
import hello.web_shopping.dto.cart.CartReturnDto;
import hello.web_shopping.dto.cart.ItemAddToCartDto;

import java.util.List;

public interface CartService {
    CartReturnDto addItemToCart(ItemAddToCartDto itemAddToCartDto);

    CartReturnDto removeItemFromCart(String memberId, String itemName, int removeQuantity);

    List<CartItemReturnDto> findCartByMemberId(String memberId);
}
