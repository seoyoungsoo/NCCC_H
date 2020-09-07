package com.example.nccc_h;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Model_Server {
    //사용될 함수 sendID (user id)
    public void sendId (String id) {
        final String userId = id;

        new Thread() {
            public void run() {
                String text = getText(userId);
            }
        }.start();
    }

    private String getText(String id) {
        try {
            OkHttpClient client = new OkHttpClient();
            RequestBody formBody = new FormBody.Builder()
                    .add("text", id)
                    .build();

            Request request = new Request.Builder()
                    .url("http://222.116.135.77:9900/test/konkuk")
                    .post(formBody)
                    .build();

            Response response = client.newCall(request).execute();
            String result = response.body().string();

            return "성공";
        } catch (Exception e) {
            e.printStackTrace();;
            return "실패";
        }
    }
}
