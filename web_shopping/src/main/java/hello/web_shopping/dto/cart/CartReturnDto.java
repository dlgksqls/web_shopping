package hello.web_shopping.dto.cart;

import hello.web_shopping.entity.Cart;
import hello.web_shopping.entity.Item;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
public class CartReturnDto {

    private String loginId;
    private int totalItem;
    List<Item> itemList;
    private Long totalPrice = 0L;

    public CartReturnDto(Cart cart) {
        this.loginId = cart.getMember().getLoginId();
        this.itemList = cart.getItemList();
        this.totalItem = cart.getItemList().size();
        this.totalPrice += cart.getTotalPrice();
    }
}
