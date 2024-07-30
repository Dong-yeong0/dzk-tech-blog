package com.dzk.blog.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
// DTO -> Data transfer object, 외부 서비스에 데이터 전송을 위한 객체 정의
public class HelloResponseDto {
    // @RequireadArgsConstructor -> final 필드를 초기화하는 생성자가 자동으로 생성된다.
    private final String name;
    private final int amount;

    // @RequiredArgsConstructor를 사용하지 않은 경우 아래 주석과 같이 생성자를 수동으로 생성해야된다.
    //    public HelloResponseDto(String name, int amount) {
    //        this.name = name;
    //        this.amount = amount;
    //    }
}
