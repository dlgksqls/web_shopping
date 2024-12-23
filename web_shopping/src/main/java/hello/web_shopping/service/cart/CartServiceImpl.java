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

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{

    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;

    @Override
    public CartReturnDto addItemToCart(ItemAddToCartDto itemAddToCartDto) {
        Item addItem = itemRepository.findByName(itemAddToCartDto.getItemName());
        Member buyMember = memberRepository.findByLoginId(itemAddToCartDto.getMemberId());
        int quantity = itemAddToCartDto.getCartQuantity();

        Cart addItemToCart = new Cart();

        addItemToCart.addNewItem(addItem, buyMember, quantity);
        cartRepository.save(addItemToCart);

        CartReturnDto returnDto = new CartReturnDto(addItemToCart);

        return returnDto;
    }
}
