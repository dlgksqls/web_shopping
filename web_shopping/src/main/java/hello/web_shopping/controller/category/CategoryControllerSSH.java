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

    @GetMapping("/add")
    public String addCategory(Model model){
        model.addAttribute("category", new CategoryRegisterDto());
        return "category/addCategory";
    }

    @PostMapping("/add")
    public String addCategoryForm(RedirectAttributes redirectAttributes, CategoryRegisterDto dto){

        categoryService.registerCategory(dto.getCategoryName());
        redirectAttributes.addFlashAttribute("successMessage", "카테고리가 성공적으로 등록되었습니다!");

        return "redirect:/categoryssh";
    }
}
