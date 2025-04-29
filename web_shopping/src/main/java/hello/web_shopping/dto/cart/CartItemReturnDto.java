package hello.web_shopping.dto.cart;

import hello.web_shopping.entity.CartItem;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CartItemReturnDto {

    String itemName;
    Long price;
    int quantity;
    LocalDateTime createdDate;

    public CartItemReturnDto(CartItem cartItem) {
        this.itemName = cartItem.getItem().getName();
        this.price = cartItem.getItem().getPrice();
        this.quantity = cartItem.getQuantity();
        this.createdDate = cartItem.getCart().getCreatedDate();
    }

    public void plusItem(CartItem duplicatedCart) {
        this.quantity += duplicatedCart.getQuantity();
    }
    public void minusItem(CartItem duplicatedCart) {this.quantity -= duplicatedCart.getQuantity();}
}
