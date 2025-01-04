package hello.web_shopping.service.file;

import hello.web_shopping.entity.Item;
import hello.web_shopping.entity.UploadFile;
import hello.web_shopping.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class FileServiceImpl implements FileService{

    @Value("${file.dir}")
    private String fileDir;

    private final FileRepository fileRepository;

    public String getFullpath(String storeFileName) {
        return fileDir + storeFileName;
    }

    @Override
    public List<UploadFile> storeFiles(List<MultipartFile> multipartFiles, Item item) throws IOException {

        List<UploadFile> storeFileResult = new ArrayList<>();

        for (MultipartFile multipartFile : multipartFiles) {
            if (!multipartFile.isEmpty()){
                UploadFile uploadFile = storeFile(multipartFile, item);
                storeFileResult.add(uploadFile);
            }
        }

        return storeFileResult;
    }

    @Override
    public UploadFile storeFile(MultipartFile multipartFile, Item item) throws IOException {
        if (multipartFile.isEmpty()) {
            return null;
        }

        String originalFileName = multipartFile.getOriginalFilename();
        String storeFileName = createStoreFileName(originalFileName);

        multipartFile.transferTo(new File(getFullpath(storeFileName)));

        UploadFile newFile = new UploadFile(originalFileName, storeFileName, item);

        fileRepository.save(newFile);

        return newFile;
    }

    /**
     * DB에 저장용 파일 이름 반환
     */
    private String createStoreFileName(String originalFilename) {
        String uuid = UUID.randomUUID().toString();
        String ext = extracted(originalFilename);
        return uuid + "." + ext;
    }

    /**
     * 확장자를 빼내는 메서드
     */
    private String extracted(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos + 1);
    }
}
