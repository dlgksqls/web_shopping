package hello.web_shopping.entity;

import hello.web_shopping.entity.enumPkg.Status;
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

    private int orderQuantity = 0;
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
    private List<CartItem> cartItemList = new ArrayList<>();

    public void addFirstItem(Member cartMember, Item addItem, int quantity, CartItem cartItem) {
        this.orderQuantity += quantity;
        this.totalPrice += addItem.getPrice() * quantity;

        this.createdDate = LocalDateTime.now();

        this.member = cartMember;
        this.cartItemList.add(cartItem);

        cartMember.getCartList().add(this);
    }

    public void addNewItem(Member cartMember, Item addItem, int quantity, CartItem newCartItem) {
        this.orderQuantity += quantity;
        this.totalPrice += addItem.getPrice() * quantity;
        this.updatedDate = LocalDateTime.now();
        this.cartItemList.add(newCartItem);
    }

    public void plusItem(Item plusItem, int quantity) {
        this.orderQuantity += quantity;
        this.totalPrice += plusItem.getPrice() * quantity;
        this.updatedDate = LocalDateTime.now();
    }
}
