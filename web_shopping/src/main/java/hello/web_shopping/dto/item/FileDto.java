package hello.web_shopping.dto.item;

import lombok.Data;

@Data
public class FileDto {

    private String uploadFileName;
    private String storeFileName;

    public FileDto(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }
}
