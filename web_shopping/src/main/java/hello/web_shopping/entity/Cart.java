package hello.web_shopping.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    public void addNewItem(Item addItem, Member buyMember, int quantity) {
        this.orderQuantity = quantity;
        this.createdDate = LocalDateTime.now();
        this.member = buyMember;
        this.order = null;
        this.item = addItem;
        this.totalPrice = addItem.getPrice() * quantity;

        buyMember.getCartList().add(this);
        addItem.getCartList().add(this);
    }
}
