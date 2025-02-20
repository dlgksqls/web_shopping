package hello.web_shopping.service.categoryItem;

import hello.web_shopping.entity.Category;
import hello.web_shopping.entity.Item;

public interface CategoryItemService {

    boolean saveCategoryItem(Item item, Category category);
}
