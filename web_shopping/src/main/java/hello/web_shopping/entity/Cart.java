package hello.web_shopping.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int orderQuantity;
    private Long totalPrice = 0L;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private Order order;

    @OneToMany(mappedBy = "cart")
    private List<Item> itemList = new ArrayList<>();

    public void addNewItem(Item addItem, Member buyMember, int quantity) {
        this.orderQuantity = quantity;
        this.createdDate = LocalDateTime.now();
        this.member = buyMember;
        this.order = null;
        this.itemList.add(addItem);
        this.totalPrice = addItem.getPrice() * quantity;

        buyMember.getCartList().add(this);
    }

    public void addPlusItem(Item addItem, int plusQuantity) {
        this.orderQuantity += plusQuantity;
        this.updatedDate = LocalDateTime.now();
        this.totalPrice += addItem.getPrice() * plusQuantity;
    }

    public void reduceItemFromCart(Item removeItem, int removeQuantity){
        this.orderQuantity -= removeQuantity;
        this.updatedDate = LocalDateTime.now();
        this.totalPrice -= removeItem.getPrice() * removeQuantity;
    }
}
