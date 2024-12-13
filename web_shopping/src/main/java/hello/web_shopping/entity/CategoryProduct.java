package hello.web_shopping.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "categoryproduct")
public class CategoryProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryproduct_id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_Id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
}
