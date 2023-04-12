package com.atguigu.chatbotapi.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * @author wjcsrart
 * @create 2023-04-09 20:29
 */

@SpringBootTest
public class ApiTest {

    /**
     * 拉取知识星球上面的回复
     */
    @Test
    public void getInfo() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/topics/814284442112522/comments?sort=asc&count=30&with_sticky=true");
        get.addHeader("cookie","zsxq_access_token=E650731A-B7F3-52BD-BB44-949876CA450D_E793AF8B597D46F7; zsxqsessionid=c65013972d751c247eed4316aa3ff010; abtest_env=product; UM_distinctid=18766172bddbf6-09cb540693affa-7e575476-144000-18766172bde1ab1; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22812581452884542%22%2C%22first_id%22%3A%2218766172d8446b-04167980e0bf08c-7e575476-1327104-18766172d85164f%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg3NjYxNzJkODQ0NmItMDQxNjc5ODBlMGJmMDhjLTdlNTc1NDc2LTEzMjcxMDQtMTg3NjYxNzJkODUxNjRmIiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiODEyNTgxNDUyODg0NTQyIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22812581452884542%22%7D%2C%22%24device_id%22%3A%2218766172d8446b-04167980e0bf08c-7e575476-1327104-18766172d85164f%22%7D");
        get.addHeader("Content-Type","application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/814284442112522/comments");
        post.addHeader("cookie","zsxq_access_token=E650731A-B7F3-52BD-BB44-949876CA450D_E793AF8B597D46F7; zsxqsessionid=c65013972d751c247eed4316aa3ff010; abtest_env=product; UM_distinctid=18766172bddbf6-09cb540693affa-7e575476-144000-18766172bde1ab1; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22812581452884542%22%2C%22first_id%22%3A%2218766172d8446b-04167980e0bf08c-7e575476-1327104-18766172d85164f%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg3NjYxNzJkODQ0NmItMDQxNjc5ODBlMGJmMDhjLTdlNTc1NDc2LTEzMjcxMDQtMTg3NjYxNzJkODUxNjRmIiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiODEyNTgxNDUyODg0NTQyIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22812581452884542%22%7D%2C%22%24device_id%22%3A%2218766172d8446b-04167980e0bf08c-7e575476-1327104-18766172d85164f%22%7D");
        post.addHeader("Content-Type","application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"成功了 发多少个！。\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"replied_comment_id\": 411858824814848,\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson,"UTF-8");
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }

}
