package com.example.demo;

import org.junit.Test;

public class SmsControllerTest extends BaseTest {

    @Test
    public void bidListTest() throws Exception {

        //String content = JsonConvertUtils.object2Json(request);
        String content = "15801834760";
        String postUrl = "/sms/send";
        doPost(postUrl, content);

    }

}
