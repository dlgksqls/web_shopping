package hello.web_shopping.controller;

import hello.web_shopping.dto.cart.CartReturnDto;
import hello.web_shopping.dto.cart.ItemAddToCartDto;
import hello.web_shopping.service.cart.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("cart")
public class CartController {

    private final CartService cartService;

    @PostMapping("")
    public ResponseEntity<CartReturnDto> addItemToCart(ItemAddToCartDto itemAddToCartDto){
        CartReturnDto returnDto = cartService.addItemToCart(itemAddToCartDto);

        return new ResponseEntity<>(returnDto, HttpStatus.ACCEPTED);
    }
}
