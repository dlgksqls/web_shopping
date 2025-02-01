package hello.web_shopping.dto.cart;

import hello.web_shopping.dto.cartitem.CartItemReturnDto;
import hello.web_shopping.entity.Cart;
import hello.web_shopping.entity.CartItem;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CartReturnDto {

    private String loginId;
    private Long totalPrice;
    private List<CartItemReturnDto> itemList = new ArrayList<>();

    public CartReturnDto(Cart cart) {
        this.loginId = cart.getMember().getLoginId();
        this.totalPrice = cart.getTotalPrice();

        for (CartItem cartItem : cart.getCartItemList()) {
            CartItemReturnDto dto = new CartItemReturnDto(cartItem);
            this.itemList.add(dto);
        }
    }
}
