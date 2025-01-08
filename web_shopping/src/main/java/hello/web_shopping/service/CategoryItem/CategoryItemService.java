package hello.web_shopping.service.CategoryItem;

import hello.web_shopping.entity.Category;
import hello.web_shopping.entity.CategoryItem;
import hello.web_shopping.entity.Item;
import jakarta.persistence.Id;

public interface CategoryItemService {

    boolean saveCategoryItem(Item item, Category category);
}
