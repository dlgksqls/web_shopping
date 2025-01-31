package hello.web_shopping.service.cart;

import hello.web_shopping.dto.cart.CartReturnDto;
import hello.web_shopping.dto.cart.ItemAddToCartDto;
import hello.web_shopping.entity.Cart;
import hello.web_shopping.entity.Item;
import hello.web_shopping.entity.Member;
import hello.web_shopping.repository.CartRepository;
import hello.web_shopping.repository.ItemRepository;
import hello.web_shopping.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CartServiceImpl implements CartService{

    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;

    @Override
    public CartReturnDto addItemToCart(ItemAddToCartDto itemAddToCartDto) {
        Item addItem = itemRepository.findByName(itemAddToCartDto.getItemName());
        Member buyMember = memberRepository.findByLoginId(itemAddToCartDto.getMemberId());
        int quantity = itemAddToCartDto.getCartQuantity();

        Cart cart = cartRepository.findCartByMemberAndItem(buyMember.getId(), addItem.getId());

        if (cart != null) {
            cart.addPlusItem(addItem, quantity);
        } else {
            cart = new Cart();
            cart.addNewItem(addItem, buyMember, quantity);
        }

        addItem.addToCart(quantity);
        cartRepository.save(cart);

        Cart cartByMember = cartRepository.findCartByLoginId(buyMember.getLoginId());

        return new CartReturnDto(cartByMember);
    }

    @Override
    public CartReturnDto removeItemFromCart(String memberId, String itemName, int removeQuantity) {
        Member findMember = memberRepository.findByLoginId(memberId);
        Item removeItem = itemRepository.findByName(itemName);

        Cart cart = cartRepository.findCartByMemberAndItem(findMember.getId(), removeItem.getId());

        if (cart == null){
            throw new NullPointerException("찾으시는 장바구니가 없습니다.");
        }

        if (removeQuantity == cart.getOrderQuantity()){
            cartRepository.delete(cart);
        }
        else{
            cart.reduceItemFromCart(removeItem, removeQuantity);
        }

        removeItem.removeFromCart(removeQuantity);
        Cart cartByLoginid = cartRepository.findCartByLoginId(findMember.getLoginId());

        return new CartReturnDto(cartByLoginid);
    }

    @Override
    public void findCartByMemberId(String memberId) {
        Cart findCart = cartRepository.findCartByLoginId(memberId);

    }
}
