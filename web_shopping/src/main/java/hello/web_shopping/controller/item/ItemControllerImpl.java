package hello.web_shopping.controller.item;

import hello.web_shopping.dto.item.ItemRegisterDto;
import hello.web_shopping.dto.item.ItemReturnDto;
import hello.web_shopping.service.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemControllerImpl implements ItemController{

    private final ItemService itemService;

    @GetMapping("")
    @Override
    public ResponseEntity<List<ItemReturnDto>> findAll() {
        List<ItemReturnDto> returnDtos = itemService.findAll();
        return new ResponseEntity<>(returnDtos, HttpStatus.ACCEPTED);
    }

    @PostMapping("")
    @Override
    public ResponseEntity<ItemReturnDto> register(ItemRegisterDto dto) throws IOException {
        ItemReturnDto returnDto = itemService.register(dto);
        return new ResponseEntity<>(returnDto, HttpStatus.CREATED);
    }

    @GetMapping("/{itemName}")
    @Override
    public ResponseEntity<List<ItemReturnDto>> findItems(@PathVariable String itemName) {
        List<ItemReturnDto> findItems = itemService.findItemsByItemName(itemName);

        return new ResponseEntity<>(findItems, HttpStatus.OK);
    }
}
