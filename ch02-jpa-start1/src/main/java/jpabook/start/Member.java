package jpabook.start;

import javax.persistence.*;  //**


@Entity // 이 클래스를 테이블과 매핑한다고 JPA에게 알려주는 역할
@Table(name="MEMBER") // 엔티티 클래스에 매핑할 테이블 정보를 알려주는 역할 
//name 속성을 사용해서 Member 엔티티를  MEMBER 테이블에 매핑 , 이 어노테이션 생략시 클래스 이름을 테이블 이름으로 매핑
public class Member {

    @Id // 엔티티 클래스의 필드를 테이블의 기본키에 매핑
    @Column(name = "ID") // 필드를 컬럼에 매핑
    private String id;

    @Column(name = "NAME")// 필드를 컬럼에 매핑
    private String username;

    private Integer age; // 매핑 정보가 없는 필드, 생략 이유는 필드명을 사용해서 컬럼명으로 매핑

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
