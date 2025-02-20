package hello.web_shopping.service.categoryItem;


import hello.web_shopping.entity.Category;
import hello.web_shopping.entity.CategoryItem;
import hello.web_shopping.entity.Item;
import hello.web_shopping.repository.CategoryItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryItemServiceImpl implements CategoryItemService{

    private final CategoryItemRepository categoryItemRepository;

    @Override
    public boolean saveCategoryItem(Item item, Category category) {
        CategoryItem newCategoryItem = new CategoryItem(item, category);
        categoryItemRepository.save(newCategoryItem);

        return true;
    }
}