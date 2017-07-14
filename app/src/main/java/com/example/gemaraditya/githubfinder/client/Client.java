package com.example.gemaraditya.githubfinder.client;

import android.util.Log;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Gema Raditya on 7/10/2017.
 */

public class Client {
    private static final String baseURL = "https://api.github.com/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static Retrofit getClient() {
        return retrofit;
    }


}
