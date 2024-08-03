package com.dzk.blog.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
// MappedSuperclass -> 객체 입장에서 공통 매핑 정보가 필요할 때 사용한다. (id, name, created_at, updated_at 등)
// JPA Entity 클래스들이 해당 클래스를 상속하는 경우 필드들도 column으로 인식.
@MappedSuperclass
// 
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifedDate;

}
