package hello.web_shopping.controller.category;

import hello.web_shopping.dto.category.CategoryRegisterDto;
import hello.web_shopping.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/categoryssh")
public class CategoryControllerSSH {

    private final CategoryService categoryService;

    @GetMapping("")
    public String categoryList(Model model){
        List<String> categoryList = categoryService.viewAllCategory();

        model.addAttribute("categoryList", categoryList);

        return "category/categoryList";
    }

    @GetMapping("/add")
    public String addCategory(Model model){

        model.addAttribute("category", new CategoryRegisterDto());
        return "category/categoryAdd";
    }

    @PostMapping("/add")
    public String addCategoryForm(RedirectAttributes redirectAttributes, CategoryRegisterDto dto){

        String category = categoryService.registerCategory(dto.getCategoryName());

        redirectAttributes.addAttribute("category",category);;

        return "redirect:/categoryssh";
    }
}
