package hello.web_shopping.dto.item;

import lombok.Data;

@Data
public class ItemOrderReturnDto {

    private String itemName;
    private Long itemPrice;

    public ItemOrderReturnDto(String itemName, Long itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }
}
