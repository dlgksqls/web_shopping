package hello.web_shopping.dto.item;

import hello.web_shopping.entity.Item;
import hello.web_shopping.entity.UploadFile;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ItemReturnDto {

    private Long id;
    private String name;
    private Long imageCount;
    private Long price;
    private int quantity;
    private LocalDateTime createdDate;
    private List<String> imageUrls = new ArrayList<>();

    public ItemReturnDto(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.imageCount = item.getUploadFileList().stream().count();
        this.price = item.getPrice();
        this.quantity = item.getQuantity();
        this.createdDate = item.getCreatedDate();

        for (UploadFile uploadFile : item.getUploadFileList()) {
            this.imageUrls.add(uploadFile.getStoreFileName());
        }
    }

    public ItemReturnDto() {
    }
}

