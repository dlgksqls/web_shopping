package hello.web_shopping.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryChildId")
    private Category category;
    @OneToMany(mappedBy = "category")
    private List<Category> categoryList = new ArrayList<>();
    @OneToMany(mappedBy = "category")
    private List<CategoryItem> categoryItemList = new ArrayList<>();

}
