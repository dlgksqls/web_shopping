package hello.web_shopping.service.cart;

import hello.web_shopping.dto.cart.CartItemReturnDto;
import hello.web_shopping.dto.cart.CartReturnDto;
import hello.web_shopping.dto.cart.ItemAddToCartDto;
import hello.web_shopping.entity.Cart;
import hello.web_shopping.entity.CartItem;
import hello.web_shopping.entity.Item;
import hello.web_shopping.entity.Member;
import hello.web_shopping.repository.CartItemRepository;
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
    private final CartItemRepository cartItemRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    @Override
    public CartReturnDto addItemToCart(ItemAddToCartDto itemAddToCartDto) {
        String loginId = itemAddToCartDto.getMemberId();
        String itemName = itemAddToCartDto.getItemName();
        int quantity = itemAddToCartDto.getCartQuantity();

        Member cartMember = memberRepository.findByLoginId(loginId);
        Item addItem = itemRepository.findByName(itemName);

        Cart cart = cartRepository.findCartByLoginId(loginId);

        if (cart == null){ // Cart가 없는 경우
            Cart newCart = new Cart();
            CartItem newcartItem = new CartItem();
            newcartItem.addCartItem(newCart, addItem, quantity);

            newCart.addFirstItem(cartMember, addItem, quantity, newcartItem);
            addItem.addToCart(quantity);

            cartRepository.save(newCart);
            cartItemRepository.save(newcartItem);
            return new CartReturnDto(newCart);
        }

        CartItem cartItem = cartItemRepository.findCartItem(itemName, loginId);

        if (cartItem == null){ // Cart는 있지만 기존에 추가돼있던 아이템이 아닌 경우
            CartItem newCartItem = new CartItem();
            newCartItem.addCartItem(cart, addItem, quantity);

            cart.addNewItem(cartMember, addItem, quantity, newCartItem);
            addItem.addToCart(quantity);

            cartItemRepository.save(newCartItem);
            return new CartReturnDto(cart);
        }

        // Cart도 존재하고, 기존에 넣었던 아이템인 경우 수량만 추가
        cartItem.plusCartItem(quantity);
        cart.plusItem(addItem, quantity);
        addItem.addToCart(quantity);

        return new CartReturnDto(cart);
    }

    @Override
    public CartReturnDto removeItemFromCart(String memberId, String itemName, int removeQuantity) {
        return null;
    }

    @Override
    public List<CartItemReturnDto> findCartByMemberId(String memberId) {
        List<CartItem> allCartItem = cartItemRepository.findAllCartItem(memberId);
        List<CartItemReturnDto> returnDto = new ArrayList<>();

        for (CartItem cartItem : allCartItem) {
            CartItemReturnDto dto = new CartItemReturnDto(cartItem);
            CartItem duplicatedCart = cartItemRepository.findCartItem(memberId, dto.getItemName());
            if (duplicatedCart != null){
                // ** 사전에 카트에 넣은 아이템이 있으면 카트를 하나 더 추가하지말고, 있던 것에 추가하고싶어 ** //
            }
            returnDto.add(dto);
        }

        return returnDto;
    }
}
