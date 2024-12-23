package hello.web_shopping.dto.cart;

import hello.web_shopping.entity.Cart;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class CartReturnDto {

    private String memberName;
    private int totalItem;

    private HashMap<String, Integer> itemList = new HashMap<>();
    private Long totalPrice = 0L;

    public CartReturnDto(Cart cart) {
        this.memberName = cart.getMember().getLoginId();
        this.totalItem = cart.getOrderQuantity();
        this.itemList.put(cart.getItem().getName(), cart.getOrderQuantity());
        this.totalPrice = cart.getTotalPrice();
    }
}
