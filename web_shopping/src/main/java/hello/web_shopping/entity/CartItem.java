package hello.web_shopping.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class CartItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    public void addCartItem(Cart newCart, Item addItem, int quantity) {
        this.cart = newCart;
        this.item = addItem;
        this.quantity = quantity;
    }

    public void plusCartItem(int plusQuantity) {
        this.quantity += plusQuantity;
    }
}
