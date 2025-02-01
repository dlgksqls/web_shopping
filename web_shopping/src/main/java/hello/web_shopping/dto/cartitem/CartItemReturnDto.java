package hello.web_shopping.dto.cartitem;

import hello.web_shopping.entity.CartItem;
import lombok.Data;

@Data
public class CartItemReturnDto {

    private String itemName;
    private int quantity;
    private Long price;

    public CartItemReturnDto(CartItem cartItem) {
        this.itemName = cartItem.getItem().getName();
        this.quantity = cartItem.getQuantity();
        this.price = cartItem.getItem().getPrice() * quantity;
    }
}
