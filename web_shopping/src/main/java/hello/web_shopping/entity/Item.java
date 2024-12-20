package hello.web_shopping.entity;

import hello.web_shopping.dto.item.ItemRegisterDto;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String image;
    private String description;
    private LocalDateTime makingDate;
    private int price;
    private int quantity;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;


    @OneToMany(mappedBy = "item")
    private List<Cart> cartList = new ArrayList<>();
    @OneToMany(mappedBy = "item")
    private List<CategoryItem> categoryItemList = new ArrayList<>();
    @OneToMany(mappedBy = "item")
    private List<Review> reviewList = new ArrayList<>();

    public void register(ItemRegisterDto itemRegisterDto) {
        this.name = itemRegisterDto.getName();
        this.image = itemRegisterDto.getImage();
        this.description = itemRegisterDto.getDescription();
        this.makingDate = itemRegisterDto.getMakingDate();
        this.price = itemRegisterDto.getPrice();
        this.quantity = itemRegisterDto.getQuantity();
        this.createdDate = LocalDateTime.now();
        this.updatedDate = createdDate;
    }
}
