package hello.web_shopping.controller.category;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/category")
public interface CategoryControllerAPI {

    public ResponseEntity<List<String>> viewAllCategory();

    public ResponseEntity<String> categoryRegister(String categoryName);
}
