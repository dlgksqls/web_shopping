package hello.web_shopping.repository;

import hello.web_shopping.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Item findByName(String itemName);

    @Query("SELECT i FROM Item i WHERE i.name LIKE CONCAT('%', :itemName, '%')")
    List<Item> findItemsByName(@Param("itemName") String itemName);
}
