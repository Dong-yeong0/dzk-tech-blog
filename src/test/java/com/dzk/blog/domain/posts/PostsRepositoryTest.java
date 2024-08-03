package com.dzk.blog.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

//
@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    // @Test
    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void insert_and_get_post() {
        // given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        // JpaRepository를 상속한 후 자동으로 생성된 save 메소드
        // https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("kevin@beomhoit.com")
                .build()
        );

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }

    @Test
    public void BaseTimeEntity_등록() {
        // given
        LocalDateTime now = LocalDateTime.of(2024, 8, 3, 0, 0, 0);
        postsRepository.save(Posts.builder().title("title").content("content").author("author").build());

        // when
        List<Posts> postList = postsRepository.findAll();

        // then
        Posts posts = postList.get(0);

        System.out.println(" >>>>>> createDate = " + posts.getCreatedDate() + ", modifiedDate = " + posts.getModifedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifedDate()).isAfter(now);
    }
}