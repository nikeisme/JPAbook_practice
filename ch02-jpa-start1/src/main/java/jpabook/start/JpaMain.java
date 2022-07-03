package jpabook.start;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
    	//영속성 유닛을 찾아서 이 팩토리를 생성하므로 유닛 이름이 동일해야함
    	//애플리케이션 전체에서 딱 한번만 생성하고 공유해서 사용해야함.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성, 등록/수정/삭제/조회 가능

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {

            tx.begin(); //트랜잭션 시작
            logic(em);  //비즈니스 로직
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료 , 반드시!
        }

        emf.close(); //엔티티 매니저 팩토리 종료, 반드시!
    }

    public static void logic(EntityManager em) {

        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUsername("지한");
        member.setAge(2);

        //등록
        em.persist(member); // INSERT INTO MEMBER(ID,NAME,AGE) VALUES ('id1','지한', 2) 실행 

        //수정
        member.setAge(20); // update라는 메소드 없음. JPA는 어떤 엔티티가 변경되었는지 추적하는 기능을 갖추고 있음

        //한 건 조회
        Member findMember = em.find(Member.class, id);
        System.out.println("findMember=" + findMember.getUsername() + ", age=" + findMember.getAge());

        //목록 조회
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        System.out.println("members.size=" + members.size());
        
        //JPQL(Java Persistence Query Language)라는 쿼리 언어로 검색해야함
        //SQL을 추상화한 객체 지향 쿼리 언어
        //select m from Member m

        //삭제
        em.remove(member); //DELETE FROM MEMBER WHERE ID = 'id1' 실행

    }
}
