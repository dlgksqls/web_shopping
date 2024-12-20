package hello.web_shopping.service.item;

import hello.web_shopping.dto.item.ItemRegisterDto;
import hello.web_shopping.dto.item.ItemReturnDto;
import hello.web_shopping.entity.Item;
import hello.web_shopping.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;

    @Override
    public ItemReturnDto register(ItemRegisterDto itemRegisterDto) {
        Item newItem = new Item();
        newItem.register(itemRegisterDto);

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
}
