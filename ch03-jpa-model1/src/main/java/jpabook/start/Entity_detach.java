package jpabook.start;

import javax.persistence.*;
import java.util.List;


public class Entity_detach{

	// detach( ) : 엔티티를 준영속 상태로 전환
		public void detach(Object entity);
		
	// detach() 테스트 코드
		
		public void testDetached () {
			...
			
			// 회원 엔티티 생성, 비영속 상태
			Member member = new Member();
			member.setId("memberA");
			member.setUsername("회원A");
			
			// 회원 엔티티 영속 상태
			em.persist(member);
			
			// 회원 엔티티를 영속성 컨텍스트에서 분리, 준영속 상태
			em.detach(member);
			
			transaction.commit(); // 트랜잭션 커밋
			
			
	// clear() : 영속성 컨텍스트 초기화
			
		Member member = Embeddable.find(Member.class, "memberA");
		
		em.clear (); // 영속성 컨텍스트 초기화
		
		//준영속 상태
		member.setUsername("changeName");

		
	// close () : 영속성 컨텍스트 종료
		
		public void closeEntityManager() {
			
			EntityManager emf =
					Persistence.createEntityManagerFactory("jpabook");
			
			EntityManager em = emf.createEntityManager();
			EntityTransaction transaction = em.getTransaction();
			
			transaction.begin(); //[트랜잭션] - 시작
			
			Member memberA = em.find(Member.class, "memberA");
			Member memberB = em.find(Member.class, "memberB");
			
			transaction.commit(); //[트랜잭션] - zjalt
			
			em.clear(); // 영속성 컨텍스트 닫기 (종료)		
		}
			
			
		}
	 	
		
	
	
	
 }
