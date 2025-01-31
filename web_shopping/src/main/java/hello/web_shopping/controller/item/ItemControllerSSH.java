package hello.web_shopping.controller.item;

import hello.web_shopping.dto.item.ItemRegisterDto;
import hello.web_shopping.dto.item.ItemReturnDto;
import hello.web_shopping.service.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/itemssh")
@RequiredArgsConstructor
public class ItemControllerSSH {

    private final ItemService itemService;

    @GetMapping("")
    public String items(Model model, @RequestParam(required = false) String loginId) {
        List<ItemReturnDto> itemList = itemService.findAll();
        model.addAttribute("itemList", itemList);
        model.addAttribute("loginId", loginId);

        return "item/itemList";
    }

    @GetMapping("/itemInfo/{itemName}")
    public String itemInfo(@PathVariable String itemName, Model model){
        ItemReturnDto findItem = itemService.findByItemName(itemName);
        model.addAttribute("item", findItem);

        return "item/itemRegisterInfo";
    }

    @GetMapping("/add")
    public String item(Model model){
        model.addAttribute("item", new ItemRegisterDto());

        return "item/itemAdd";
    }
    @PostMapping("/add")
    public String itemAdd(Model model, @ModelAttribute ItemRegisterDto newItem) throws IOException {

        String encodedCode;

        try {
            ItemReturnDto registeredItem = itemService.register(newItem);
            String itemName = registeredItem.getName();
            encodedCode = URLEncoder.encode(itemName, "UTF-8").toString();

            return "redirect:/itemssh/itemInfo/" + encodedCode;
        } catch (Exception e) {
            model.addAttribute("errorMessage", "아이템 등록 중 오류가 발생했습니다. " + e.getMessage());
            return "item/itemAdd";
        }
    }
}