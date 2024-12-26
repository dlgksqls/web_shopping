package hello.web_shopping.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class CategoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryItem_Id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemId")
    private Item item;
}
