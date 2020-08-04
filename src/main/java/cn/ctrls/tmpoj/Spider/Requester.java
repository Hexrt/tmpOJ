package cn.ctrls.tmpoj.Spider;

import okhttp3.*;
import org.apache.http.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component(value = "requester")
public class Requester {
    OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");
    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:79.0) Gecko/20100101 Firefox/79.0";
    String get(String url) {
        Request request = new Request.Builder()
                .url(url)
                .header("User-Agent",USER_AGENT)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }catch (IOException e){
            return null;
        }
    }

    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .header("User-Agent",USER_AGENT)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    String get(String url, String cookie){
        Request request = new Request.Builder()
                .url(url)
                .header("User-Agent",USER_AGENT)
                .addHeader("cookie",cookie)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }catch (IOException e){
            return null;
        }
    }

//    String getJson(String url, String cookie){
//
//    }

    String post(String url, String json, Cookie cookie) throws IOException {
        return post(url, json);
    }
}
