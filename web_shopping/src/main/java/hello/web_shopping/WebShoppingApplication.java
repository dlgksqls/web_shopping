package hello.web_shopping;

import hello.web_shopping.entity.Item;
import hello.web_shopping.entity.Member;
import hello.web_shopping.repository.ItemRepository;
import hello.web_shopping.repository.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class WebShoppingApplication {

	private final MemberRepository memberRepository;
	private final ItemRepository itemRepository;

	public static void main(String[] args) {
		SpringApplication.run(WebShoppingApplication.class, args);
	}

	@PostConstruct
	public void init(){
		Member adminMember = new Member();
		adminMember.createAdminMember();

		Item firstItem = new Item();
		firstItem.createFirstItem();

		memberRepository.save(adminMember);
		itemRepository.save(firstItem);
	}

}
