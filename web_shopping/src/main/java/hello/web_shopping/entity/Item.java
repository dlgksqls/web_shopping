package hello.web_shopping.entity;

import hello.web_shopping.dto.item.ItemRegisterDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

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
//    private String image;
    private String description;
    private LocalDateTime makingDate;
    private Long price;
    private int quantity;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<CategoryItem> categoryItemList = new ArrayList<>();
    @OneToMany(mappedBy = "item")
    private List<Review> reviewList = new ArrayList<>();
    @OneToMany(mappedBy = "item")
    private List<UploadFile> uploadFileList = new ArrayList<>();

    public void register(ItemRegisterDto itemRegisterDto) {
        this.name = itemRegisterDto.getName();
        this.description = itemRegisterDto.getDescription();
        this.makingDate = itemRegisterDto.getMakingDate();
        this.price = itemRegisterDto.getPrice();
        this.quantity = itemRegisterDto.getQuantity();
        this.createdDate = LocalDateTime.now();
        this.updatedDate = createdDate;
    }

    public void addImage(List<UploadFile> uploadFileList){
        this.uploadFileList = uploadFileList;
    }

    public void addCategory(Category categoryList) {
//        for (Category category : categoryList) {
//            CategoryItem categoryItem = new CategoryItem(this, category);
//            this.categoryItemList.add(categoryItem);
//            category.getCategoryItemList().add(categoryItem);
//        }
        CategoryItem categoryItem = new CategoryItem(this, categoryList);
        this.categoryItemList.add(categoryItem);
        categoryList.getCategoryItemList().add(categoryItem);
    }

    public void createFirstItem() {
        this.name = "콘칩";
        this.price = 100L;
        this.quantity = 10;
        this.createdDate = LocalDateTime.now();
        this.updatedDate = null;
    }

    public void addToCart(int quantity) {
        if (this.quantity < quantity) {
            throw new IllegalArgumentException("수량 부족합니다 더 적게 사주세요.");
        }
        if (this.quantity == 0){
            throw new IllegalStateException("재고가 없습니다. 나중에 확인해주세요.");
        }

        this.quantity -= quantity;
    }

    public void addReview(Review review) {
        this.reviewList.add(review);
    }
}
