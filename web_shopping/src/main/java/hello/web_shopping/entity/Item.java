package hello.web_shopping.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
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
}
