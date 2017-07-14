package com.example.gemaraditya.githubfinder.presenter;

import android.util.Log;
import android.widget.Toast;

import com.example.gemaraditya.githubfinder.R;
import com.example.gemaraditya.githubfinder.client.Client;
import com.example.gemaraditya.githubfinder.client.GitFinderInterface;
import com.example.gemaraditya.githubfinder.model.User;
import com.example.gemaraditya.githubfinder.model.UserResponse;
import com.example.gemaraditya.githubfinder.view.MainCallback;

import java.net.InetAddress;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Gema Raditya on 7/13/2017.
 */

public class MainPresenter implements Presenter<MainCallback> {
    private MainCallback mainCallback;
    private List<User> userList;
    private final int okStatus = 200;

    @Override
    public void attachView(MainCallback view) {
        this.mainCallback = view;
    }

    @Override
    public void detachView() {
        this.mainCallback = null;
    }

    public void searchUser(String users , String pageLimit) {
        GitFinderInterface service = Client.getClient().create(GitFinderInterface.class);
        Call<UserResponse> call = service.getUsername(users, pageLimit);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.code() == okStatus) {
                    userList = response.body().getItems();
                    if (!userList.isEmpty()) {
                        // display user list
                        mainCallback.displayUsers(userList);

                    } else {
                        // empty user data case
                        mainCallback.displayText(R.string.empty_user_message);
                    }
                }
                else {
                    // 403 API Hit limit case
                    mainCallback.displayText(R.string.limit_rate_message);
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.e("err", t.toString());
            }
        });
    }

}
