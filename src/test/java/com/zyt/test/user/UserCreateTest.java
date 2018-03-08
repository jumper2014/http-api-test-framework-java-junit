package com.zyt.test.user;

import com.zyt.http.Request;
import net.sf.json.JSONObject;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class UserCreateTest {

    @Test
    public void createNewUser() {
        String JSON_SIMPLE = "{'name':'tom','age':16}";
        JSONObject body = JSONObject.fromObject(JSON_SIMPLE);
        Request request = new Request();
        String url = "http://127.0.0.1:8080/user";
        HttpResponse  response = request.httpPostWithJson(body, url);
        StatusLine status = response.getStatusLine();
        int state = status.getStatusCode();
        if (state == HttpStatus.SC_OK) {
            HttpEntity responseEntity = response.getEntity();
            String jsonString = null;
            try {
                jsonString = EntityUtils.toString(responseEntity);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else{
            fail("result :"+state+"("+url+")");
        }
    }

}
