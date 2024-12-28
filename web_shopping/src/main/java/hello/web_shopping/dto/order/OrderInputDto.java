package hello.web_shopping.dto.order;

import lombok.Data;

@Data
public class OrderInputDto {

    private Long cartId;
    private String memberId;

    public OrderInputDto(Long cartId, String memberId) {
        this.cartId = cartId;
        this.memberId = memberId;
    }
}
