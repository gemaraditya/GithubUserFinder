package com.example.gemaraditya.githubfinder.client;

import com.example.gemaraditya.githubfinder.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Gema Raditya on 7/10/2017.
 */

public interface GitFinderInterface {
    @GET("search/users")
    Call<UserResponse> getUsername(@Query("q") String username, @Query("per_page") String page);

}
