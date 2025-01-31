package hello.web_shopping.controller.category;

import hello.web_shopping.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/categoryssh")
@RequiredArgsConstructor
public class CategoryControllerSSH {

    private final CategoryService categoryService;

    @GetMapping("")
    public String allCategory(Model model){
        List<String> categoryList = categoryService.viewAllCategory();
        model.addAttribute("categoryList", categoryList);
        return "category/allCategory";
    }
}
