package hello.web_shopping.dto.order;

import lombok.Data;

@Data
public class OrderReturnDto {

    private Long totalPrice;

    public OrderReturnDto(Long totalPrice) {
        this.totalPrice = totalPrice;
    }
}
