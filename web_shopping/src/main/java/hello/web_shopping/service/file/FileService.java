package hello.web_shopping.service.file;

import hello.web_shopping.entity.Item;
import hello.web_shopping.entity.UploadFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {

    List<UploadFile> storeFiles(List<MultipartFile> multipartFiles, Item item) throws IOException;

    UploadFile storeFile(MultipartFile multipartFile, Item item) throws IOException;
}
