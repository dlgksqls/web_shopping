package hello.web_shopping.controller.category;

import hello.web_shopping.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryControllerAPIImpl implements CategoryControllerAPI {

    private final CategoryService categoryService;

    @Override
    @GetMapping("")
    public ResponseEntity<List<String>> viewAllCategory() {

        List<String> categoryList = categoryService.viewAllCategory();

        return new ResponseEntity<>(categoryList, HttpStatus.ACCEPTED);
    }

    @Override
    @PostMapping("")
    public ResponseEntity<String> categoryRegister(String categoryName) {

        categoryService.registerCategory(categoryName);

        return new ResponseEntity<>(categoryName, HttpStatus.CREATED);
    }
}
