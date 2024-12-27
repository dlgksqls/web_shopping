package hello.web_shopping.controller.item;

import hello.web_shopping.dto.item.ItemRegisterDto;
import hello.web_shopping.dto.item.ItemReturnDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/item")
public interface ItemController {

    ResponseEntity<List<ItemReturnDto>> findAll();

    ResponseEntity<ItemReturnDto> register(ItemRegisterDto dto);

    ResponseEntity<List<ItemReturnDto>> findItems(String itemName);
}
