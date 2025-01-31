package hello.web_shopping.dto.category;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class CategoryRegisterDto {

    private String categoryName;

    public CategoryRegisterDto() {
    }

    public CategoryRegisterDto(String categoryName) {
        this.categoryName = categoryName;
    }
}
