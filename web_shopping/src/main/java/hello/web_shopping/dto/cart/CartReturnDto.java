package hello.web_shopping.dto.cart;

import hello.web_shopping.entity.Cart;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class CartReturnDto {

    private String memberName;
    private int totalItem;

    private HashMap<String, String> itemQuantityMap = new HashMap<>();
    private HashMap<String, String> itemPriceMap = new HashMap<>();
    private Long totalPrice = 0L;

    public CartReturnDto(List<Cart> memberCart) {
        this.memberName = memberCart.get(0).getMember().getLoginId();

        for (Cart cart : memberCart) {
            String itemName = cart.getItem().getName();
            Long itemPrice = cart.getItem().getPrice();
            int itemQuantity = cart.getOrderQuantity();
            Long itemQuantityPrice = itemPrice * itemQuantity;

            this.itemQuantityMap.put(itemName, itemQuantity + "개");
            this.itemPriceMap.put(itemName, itemPrice + "원 x " + itemQuantity + " : " + itemQuantityPrice);

            this.totalPrice += cart.getTotalPrice();
        }
    }
}
