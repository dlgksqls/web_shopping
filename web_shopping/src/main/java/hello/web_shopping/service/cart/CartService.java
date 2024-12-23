package hello.web_shopping.service.cart;

import hello.web_shopping.dto.cart.CartReturnDto;
import hello.web_shopping.dto.cart.ItemAddToCartDto;
import hello.web_shopping.entity.Item;

public interface CartService {
    CartReturnDto addItemToCart(ItemAddToCartDto itemAddToCartDto);
}
