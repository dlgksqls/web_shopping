package hello.web_shopping.service.category;

import java.util.List;

public interface CategoryService {

    public List<String> viewAllCategory();

    public String registerCategory(String categoryName);
}
