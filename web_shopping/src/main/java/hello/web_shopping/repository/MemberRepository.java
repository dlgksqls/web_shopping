package hello.web_shopping.repository;

import hello.web_shopping.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByLoginId(String memberId);
}
