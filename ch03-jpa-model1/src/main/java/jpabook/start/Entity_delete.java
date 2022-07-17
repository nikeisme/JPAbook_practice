package jpabook.start;

import javax.persistence.*;
import java.util.List;


public class Entity_delete{

	Member memberA  = em.find(Member.class, "memberA"); // 삭제 대상 엔티티 조회
	em.remove(memberA); // 엔티티 삭제

	//JPQL 실행 코드
	em.persist(memberA);
	em.persist(memberB);
	em.persist(memberC);
	
	//중간에 JPQL 실행
	query = em.createQuery("select m from Member m ", Member.class);
	List<Member> members = query.getResultList();
	
}
