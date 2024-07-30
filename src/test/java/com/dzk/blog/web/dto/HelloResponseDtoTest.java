package com.dzk.blog.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HelloResponseDtoTest {
    @Test
    public void lombok_function_test() {
       // given
        String name = "test";
        int amount = 1_000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

    @Test
    public void return_helloDto() {
        String name = "hello";
        int amount = 1_000;


    }
}