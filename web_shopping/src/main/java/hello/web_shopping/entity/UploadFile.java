package hello.web_shopping.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class UploadFile {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uploadFileName;
    private String storeFileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemId")
    private Item item;

    public UploadFile(String uploadFileName, String storeFileName, Item item) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
        this.item = item;
    }
}
