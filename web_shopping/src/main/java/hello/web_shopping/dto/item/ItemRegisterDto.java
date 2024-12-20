package hello.web_shopping.dto.item;

import hello.web_shopping.entity.Item;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ItemRegisterDto {

    private String name;
    private String image;
    private String description;
    private int price;
    private int quantity;
    private LocalDateTime makingDate;

    public ItemRegisterDto(String name, String image, String description, int price, int quantity, LocalDateTime makingDate) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.makingDate = makingDate;
    }
}
