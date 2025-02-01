package hello.web_shopping.dto.order;

import hello.web_shopping.dto.item.ItemOrderReturnDto;
import hello.web_shopping.entity.Cart;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderReturnDto {

    private Long totalPrice;
    private List<ItemOrderReturnDto> orderItemList = new ArrayList<>();

    public OrderReturnDto(Long totalPrice, List<Cart> orderCarts) {
//        this.totalPrice = totalPrice;
//
//        for (Cart orderCart : orderCarts) {
//            String itemName = orderCart.getItem().getName();
//            Long itemPrice = orderCart.getItem().getPrice();
//
//            this.orderItemList.add(new ItemOrderReturnDto(itemName, itemPrice));
//        }
    }
}
