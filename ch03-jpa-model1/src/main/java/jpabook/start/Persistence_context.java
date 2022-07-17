package jpabook.start;

import javax.persistence.*;
import java.util.List;

public class Persistence_context{

	// 엔티티 매니저를 사용해서 회원 엔티티를 영속성 컨텍스트에 저장한다.
		em.persisit(member);

	// 엔티티의 생명주기 
	// 1. 비영속
		Member number = new Member();
		member.setId("member1");
		member.setUsername("회원1");
		
	// 2. 영속
		em.persist(member);
		
	// 3. 준영속
		em.detach(member);
		
	// 4. 삭제
		em.remove(member);
	
}
