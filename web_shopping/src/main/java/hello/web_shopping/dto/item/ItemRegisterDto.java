package hello.web_shopping.dto.item;

import hello.web_shopping.entity.Item;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ItemRegisterDto {

    private String name;
//    private String image;
    private List<MultipartFile> imageList = new ArrayList<>();
//    private List<String> categoryList = new ArrayList<>();
//    private String category;
    private String description;
    private Long price;
    private int quantity;
    private LocalDateTime makingDate;

    public ItemRegisterDto() {
    }

    public ItemRegisterDto(String name, String category, List<MultipartFile> imageList, String description, Long price, int quantity, LocalDateTime makingDate) {
        this.name = name;
        this.imageList = imageList;
//        this.category = category;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.makingDate = makingDate;
    }
}
