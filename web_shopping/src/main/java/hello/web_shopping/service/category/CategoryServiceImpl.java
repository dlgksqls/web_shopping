package hello.web_shopping.service.category;

import hello.web_shopping.entity.Category;
import hello.web_shopping.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public List<String> viewAllCategory() {
        List<String> returnCategory = new ArrayList<>();

        List<Category> allCategory = categoryRepository.findAll();

        for (Category category : allCategory) {
            returnCategory.add(category.getName());
        }

        return returnCategory;
    }

    @Override
    public String registerCategory(String categoryName) {
        Category newCategory = new Category();
        newCategory.createCategory(categoryName);

        categoryRepository.save(newCategory);
        return "categoryName";
    }
}
