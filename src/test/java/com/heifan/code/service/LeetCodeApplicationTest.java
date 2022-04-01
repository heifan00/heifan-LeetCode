package com.heifan.code.service;

import com.google.gson.Gson;
import com.heifan.code.LeetCodeApplication;
import com.heifan.code.utils.JsonTool;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * @ExtendWith(SpringExtension.class)
 * 在测试中使用Spring测试框架功能
 * 则必须使用@ExtendWith(SpringExtension.class)。
 * 它取代了不推荐使用的JUnit4@RunWith(SpringJUnit4ClassRunner.class)
 * @AutoConfigureMockMvc
 * 该注解表示 MockMvc由spring容器构建，你只负责注入之后用就可以了。这种写法是为了让测试在Spring容器环境下执行
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = LeetCodeApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class LeetCodeApplicationTest {

    @Autowired
    protected MockMvc mockMvc;

    public static final String APPLICATION_JSON_UTF8_VALUE = "application/json;charset=UTF-8";

    @Autowired
    protected WebApplicationContext webApplicationContext;

    protected MvcResult executePost(Object object, String path, String token) throws Exception {
        log.info("param {}", JsonTool.beanToJson(object));
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .post(path)
                        .contentType(APPLICATION_JSON_UTF8_VALUE)
                        .content(new Gson().toJson(object))
                        // 设置返回值类型为utf-8，否则默认为ISO-8859-1
                        .accept(APPLICATION_JSON_UTF8_VALUE)
                        .header(HttpHeaders.AUTHORIZATION, token)

                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/
                .andExpect(jsonPath("$.code").value(200))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        response.setCharacterEncoding("UTF-8");
        return mvcResult;
    }

    protected MvcResult executeGet(String path, String token) throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .get(path)
                        // 设置返回值类型为utf-8，否则默认为ISO-8859-1
                        .accept(APPLICATION_JSON_UTF8_VALUE)
                        .header(HttpHeaders.AUTHORIZATION, token)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/
                .andExpect(jsonPath("$.code").value(200))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        response.setCharacterEncoding("UTF-8");
        return mvcResult;
    }
}
