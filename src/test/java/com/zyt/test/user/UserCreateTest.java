package com.zyt.test.user;

import com.zyt.http.Request;
import net.sf.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UserCreateTest {

    @Test
    public void createNewUser() {
        String JSON_SIMPLE = "{'name':'tom','age':16}";
        JSONObject body = JSONObject.fromObject(JSON_SIMPLE);
        Request request = new Request();
        String url = "http://127.0.0.1:8080/user";
        request.httpPostWithJson(body, url);
    }

}
