package hello.web_shopping.repository;

import hello.web_shopping.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    // 이렇게 fetch join  하면 안됨,, 기준을 정해야함
//    @Query("SELECT c FROM Cart c JOIN FETCH Member m join fetch Item i WHERE c.member.id = :memberId AND c.item.id = :itemId")
//    Cart findCartByMemberAndItem(@Param("memberId") Long memberId, @Param("itemId") Long itemId);

    @Query("SELECT c FROM Cart c JOIN FETCH c.member m JOIN FETCH c.item i WHERE m.id = :memberId AND i.id = :itemId")
    Cart findCartByMemberAndItem(@Param("memberId") Long memberId, @Param("itemId") Long itemId);

    @Query("SELECT c FROM Cart c JOIN FETCH c.member m WHERE m.id = :memberId")
    List<Cart> findCartByMember(@Param("memberId") Long memberId);

    @Query("SELECT c FROM Cart c JOIN FETCH c.member m WHERE m.loginId = :loginId")
    Cart findCartByLoginId(@Param("loginId") String loginId);

    @Query("SELECT c FROM Cart c WHERE c.id = :cartId")
    Cart findByCartId(Long cartId);
}
