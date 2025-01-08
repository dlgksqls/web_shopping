package hello.web_shopping.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class CategoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryItem_Id;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryId")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "itemId")
    private Item item;

    public CategoryItem(Item item, Category category) {
        this.item = item;
        this.category = category;
    }

    public CategoryItem() {

    }
}
