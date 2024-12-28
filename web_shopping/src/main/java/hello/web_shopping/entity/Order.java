package hello.web_shopping.entity;

import hello.web_shopping.entity.enumPkg.Status;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderPrice;
    private String request;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    @Enumerated(EnumType.STRING)
    private Status status;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<Cart> cartList = new ArrayList<>();

    public void createOrder(Cart orderCart, String request) {

        this.orderPrice = orderCart.getTotalPrice();
        this.request = request;
        this.createdDate = null;
        this.status = Status.ORDER;
        this.member = orderCart.getMember();
        this.cartList.add(orderCart);
    }
}
