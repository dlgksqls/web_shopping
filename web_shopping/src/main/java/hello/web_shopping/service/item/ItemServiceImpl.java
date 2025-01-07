package hello.web_shopping.service.item;

import hello.web_shopping.dto.item.ItemRegisterDto;
import hello.web_shopping.dto.item.ItemReturnDto;
import hello.web_shopping.entity.Category;
import hello.web_shopping.entity.CategoryItem;
import hello.web_shopping.entity.Item;
import hello.web_shopping.entity.UploadFile;
import hello.web_shopping.repository.CategoryItemRepository;
import hello.web_shopping.repository.CategoryRepository;
import hello.web_shopping.repository.ItemRepository;
import hello.web_shopping.service.file.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;
    private final FileService fileService;
    private final CategoryRepository categoryRepository;
    private final CategoryItemRepository categoryItemRepository;

    @Override
    public ItemReturnDto register(ItemRegisterDto itemRegisterDto) throws IOException {
        Item newItem = new Item();
        newItem.register(itemRegisterDto);

        List<UploadFile> uploadFileList = fileService.storeFiles(itemRegisterDto.getImageList(), newItem);
        newItem.addImage(uploadFileList);

        List<Category> categoryList = categoryRepository.findAllByCategoryName(itemRegisterDto.getCategoryList());
        newItem.addCategory(categoryList);

        itemRepository.save(newItem);

        ItemReturnDto returnDto = new ItemReturnDto(newItem);

        return returnDto;
    }

    @Override
    public List<ItemReturnDto> findAll() {
        List<Item> items = itemRepository.findAll();
        List<ItemReturnDto> returnDtos = new ArrayList<>();

        for (Item item : items) {
            ItemReturnDto dto = new ItemReturnDto(item);
            returnDtos.add(dto);
        }

        return returnDtos;
    }

    @Override
    public List<ItemReturnDto> findItemsByItemName(String itemName) {
        List<Item> items = itemRepository.findItemsByName(itemName);
        List<ItemReturnDto> returnDtos = new ArrayList<>();

        for (Item item : items) {
            ItemReturnDto dto = new ItemReturnDto(item);

            returnDtos.add(dto);
        }

        return returnDtos;
    }
}
