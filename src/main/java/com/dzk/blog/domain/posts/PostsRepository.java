package com.dzk.blog.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    /**
     * DB에 직접적으로 접근하는 layer
     * Mybatis (Query mapper라는 유형) 에서는 Dao (Data Access object) 라고 불리고
     * JPA 에서는 Repository라고 부른다.
     * Interface로 생성하며 JpaRepository<Entity class, PK Type>를 상송하면 기본적인 CRUD가 자동으로 생성된다.
     * Entity 클래스와 기본 Entity Repository는 같은 위치에 있어야 한다.
     * 그 이유는 프로젝트 규모가 커져 서비스 별로 분리해야 할 경우 Entity 클래스와 기본 Repository는 함께 움직여야 하므로 도메인 패키지에서 함께 관리하는 것이 효율적일거 같다.
     */
}
