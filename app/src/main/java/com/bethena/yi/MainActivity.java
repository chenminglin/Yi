package com.bethena.yi;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.bethena.yi.bean.Home;
import com.bethena.yi.net.HttpHelper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {
    String TAG = getClass().getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Request.Builder builder = new Request.Builder();
        RequestBody requestBody = new FormBody.Builder()
                .add("pagecount", "20")
                .add("num", "20")
                .add("channel", "defualt")
                .add("verb", "4001400")
                .add("verb", "7")
                .add("eqid", "b61f045060e9")
                .add("eqid", "b61f045060e9")
                .add("contype", "0 ")
                .add("version", "4001400 ")
                .add("protype", "0")
                .add("yusic002", "android")
                .add("order_by", "0")
                .add("PHPSESSID", "6gbau2agpqTJ2KNomG-WY2xmmZacbF3Sq8dudNHSmWqYcJRpa1bY29abdJI.r")
                .add("page", "1")
                .add("density", "3.0")
                .build();

        builder.url(HttpHelper.COURSE_TV).post(requestBody);
        Call call = HttpHelper.getInstance().okHttpClient.newCall(builder.build());
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, e.getMessage());

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    ResponseBody responseBody = response.body();
                    String body = responseBody.string();
                    Log.d(TAG, "body = " + body);
//                    if (body!=null){
//                        Home home = HttpHelper.getInstance().gson.fromJson(body, Home.class);
//
//                        for(Home.DatasBean datasBean:home.getDatas()){
//                            Log.d(TAG,"datasBean = "+datasBean.getDesc());
//                        }
//                    }

                }
            }
        });

    }
}
