package hello.web_shopping.dto.item;

import hello.web_shopping.entity.Item;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ItemReturnDto {

    private Long id;
    private String name;
    private int price;
    private int quantity;
    private LocalDateTime createdDate;

    public ItemReturnDto(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.price = item.getPrice();
        this.quantity = item.getQuantity();
        this.createdDate = item.getCreatedDate();
    }
}


