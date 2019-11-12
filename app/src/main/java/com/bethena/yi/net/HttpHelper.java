package com.bethena.yi.net;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpHelper {
    private static final HttpHelper ourInstance = new HttpHelper();

    public static HttpHelper getInstance() {
        return ourInstance;
    }

    private final static String BASE_URL = "http://edu.yusi.tv/";

    public final static String COURSE_TV = BASE_URL+"?urlparam=mobile4000/mycenter/home";

    public Retrofit retrofit ;

    public OkHttpClient okHttpClient;

    public Gson gson = new Gson();

    private HttpHelper() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS);
        okHttpClient = okHttpClientBuilder.build();

//        Retrofit.Builder retrofitBuilder = new Retrofit.Builder();
//        retrofitBuilder.client(okHttpClientBuilder.build());
//        retrofitBuilder.baseUrl(BASE_URL);
//        retrofitBuilder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
//        Gson gson = new Gson();
//        retrofitBuilder.addConverterFactory(GsonConverterFactory.create(gson));
//
//        retrofit = retrofitBuilder.build();
//        retrofit.create(ApiService.class);
    }
}
