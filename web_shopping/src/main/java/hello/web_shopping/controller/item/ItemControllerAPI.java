package hello.web_shopping.controller.item;

import hello.web_shopping.dto.item.ItemRegisterDto;
import hello.web_shopping.dto.item.ItemReturnDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@RequestMapping("/item")
public interface ItemControllerAPI {

    ResponseEntity<List<ItemReturnDto>> findAll();

    ResponseEntity<ItemReturnDto> register(ItemRegisterDto dto) throws IOException;

    ResponseEntity<List<ItemReturnDto>> findItems(String itemName);
}
