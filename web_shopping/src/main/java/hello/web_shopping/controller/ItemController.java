package hello.web_shopping.controller;

import hello.web_shopping.dto.item.ItemRegisterDto;
import hello.web_shopping.dto.item.ItemReturnDto;
import hello.web_shopping.service.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @GetMapping("")
    public ResponseEntity<List<ItemReturnDto>> findAll(){
        List<ItemReturnDto> returnDtos = itemService.findAll();
        return new ResponseEntity<>(returnDtos, HttpStatus.ACCEPTED);
    }

    @PostMapping("")
    public ResponseEntity<ItemReturnDto> register(ItemRegisterDto dto){

        ItemReturnDto returnDto = itemService.register(dto);
        return new ResponseEntity<>(returnDto, HttpStatus.CREATED);
    }
}
