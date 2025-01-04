package hello.web_shopping.service.item;

import hello.web_shopping.dto.item.ItemRegisterDto;
import hello.web_shopping.dto.item.ItemReturnDto;
import hello.web_shopping.entity.Item;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

public interface ItemService {

    ItemReturnDto register(ItemRegisterDto itemRegisterDto) throws IOException;

    List<ItemReturnDto> findAll();

    List<ItemReturnDto> findItemsByItemName(String itemName);
}
