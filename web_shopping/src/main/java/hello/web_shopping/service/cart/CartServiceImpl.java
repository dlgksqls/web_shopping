package hello.web_shopping.service.cart;

import hello.web_shopping.dto.cart.CartReturnDto;
import hello.web_shopping.entity.Item;
import hello.web_shopping.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{

    private final CartRepository cartRepository;

    @Override
    public CartReturnDto addItemToCart(Item item) {
        return null;
    }
}
