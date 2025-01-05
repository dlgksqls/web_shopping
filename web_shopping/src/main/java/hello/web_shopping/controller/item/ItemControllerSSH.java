package hello.web_shopping.controller.item;

import hello.web_shopping.dto.item.ItemReturnDto;
import hello.web_shopping.service.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/itemssh")
@RequiredArgsConstructor
public class ItemControllerSSH {

    private final ItemService itemService;

    @GetMapping("")
    public String items(Model model){
        List<ItemReturnDto> itemList = itemService.findAll();
        model.addAttribute("itemList", itemList);
        return "item/itemList";
    }
}
