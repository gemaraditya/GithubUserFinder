package com.example.gemaraditya.githubfinder.view;

import android.content.Context;

import com.example.gemaraditya.githubfinder.model.User;

import java.util.List;

/**
 * Created by Gema Raditya on 7/13/2017.
 */

public interface MainCallback {
    Context getContext();

    void displayUsers(List<User> userList);

    void displayText(int textId);
}
