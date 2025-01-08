package hello.web_shopping.repository;

import hello.web_shopping.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM Category c WHERE c.name = :categoryNames")
    Category findAllByCategoryName(@Param("categoryNames") String categoryNames);
}
