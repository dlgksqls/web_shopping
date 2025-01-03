package hello.web_shopping.dto.order;

import lombok.Data;

@Data
public class OrderInputDto {

    private String memberId;

    public OrderInputDto(String memberId) {
        this.memberId = memberId;
    }
}
