package hello.web_shopping.repository;

import hello.web_shopping.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    // CartItem 과 Member랑 조인 불가능,, 연관관계가 설정 안돼잇음
//    @Query("SELECT ci FROM CartItem ci JOIN FETCH ci.cart.member m JOIN FETCH ci.item i WHERE m.loginId = :loginId AND i.name = :itemName")
//    CartItem findCartItem(@Param("itemName") String itemName, @Param("loginId") String loginId);

    @Query("SELECT ci FROM CartItem ci JOIN FETCH ci.cart c WHERE c.member.loginId = :memberLoginId")
    List<CartItem> findAllCartItem(@Param("memberLoginId") String memberLoginId);

    @Query("SELECT ci FROM CartItem ci JOIN FETCH ci.cart c JOIN FETCH ci.item i WHERE c.member.loginId = :memberLoginId AND i.name = :itemName")
    CartItem findCartItem(@Param("memberLoginId") String memberLoginId, @Param("itemName") String itemName);
}
