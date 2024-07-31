package com.dzk.blog.domain.posts;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

// 테이블과 연결 될 클래스임을 나타낸다. (CmUser.java -> cm_user.table)
@Entity
public class Posts {
    /**
     * 해당 테이블의 Primary key field를 나타낸다.
     * Primany key 생성 규칙을 나타냄 (spring boot 2.0 이후 GenerationType.IDENTITY 옵션을 추가해야지 auto increment 가 된다.)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * @Column -> 엔티티 클래스 필드를 DB의 컬럼에 매핑하는데 사용.
     * 선언하지 않더라도 엔티티 클래스 필드 모두 @Column 이 적용
     * 사용이유는 기본값 외 추가로 변경이 필요한 옵션이 있으면 사용함
     * 문자열의 경우 VARCHAR(255) 가 기본값인데, 사이즈를 500으로 늘리고 싶거나, TYPE 을 TEXT 로 변경하고 싶을 때 사용
     */
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
