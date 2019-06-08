package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 单元测试基类，测试case直接继承即可 web controller的测试
 *
 * @author wangzhifeng
 */
@RunWith(SpringRunner.class)

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = { DemoApplication.class })

public class BaseTest {
    public static final Logger    log = LoggerFactory.getLogger(BaseTest.class);

    @Autowired
    private WebApplicationContext wac;

    protected MockMvc             mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testOK() {
        System.out.println("junit is ok");
    }

    protected void doPost(String postUrl, String content) throws UnsupportedEncodingException, Exception {
        String result = mockMvc.perform(post(postUrl).content(content).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        log.info("post request result:{}", result);

    }

    protected void doGet(String url, String content) throws UnsupportedEncodingException, Exception {
        String result = mockMvc.perform(get(url).content(content)).andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();
        log.info("get request result:{}", result);
    }

}
