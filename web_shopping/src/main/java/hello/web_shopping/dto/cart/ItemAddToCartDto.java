package hello.web_shopping.dto.cart;

import lombok.Data;

@Data
public class ItemAddToCartDto {

    private String itemName;
    private String memberId;
    private int cartQuantity;
}
