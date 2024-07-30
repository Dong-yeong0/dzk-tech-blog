package com.dzk.blog.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc; // web 테스트 시 HTTP GET, POST 등에 대한 API 테스트를 할 수 있음

    @Test
    public void hello() throws Exception {
        ResultActions result = mockMvc.perform(get("/hello"));

        // status().isOk() -> HTTP header 의 Status code (200, 404, 500)를 검증
        result.andExpect(status().isOk())
                .andExpect(content().string(containsString("hello")));
    }

    @Test
    public void return_helloDto() throws Exception{
        String name = "hello";
        int amount = 1_000;

        mockMvc.perform(
                        get("/hello/dto")
                            // param() -> API 테스트 시 사용될 요청 파라미터를 설정한다.
                            // 단, String type 만 허용 (int, date type 인 경우 string 으로 변환해야함)
                            .param("name", name)
                            .param("amount", String.valueOf(amount))
        )
                .andExpect(status().isOk())
                // JSON 응답값을 필드별로 검증, $ 표시 기준으로 필드명 명시 (ex -> $.field_name)
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}