package hello.web_shopping.dto.cart;

import java.util.HashMap;
import java.util.List;

public class CartReturnDto {

    private String memberName;
    private int totalItem;

    private HashMap<String, Integer> itemList = new HashMap<>();
    private int totalPrice = 0;
}
