package com.example.gemaraditya.githubfinder.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Gema Raditya on 7/10/2017.
 */

public class User {
    @SerializedName("login")
    private String login;
    @SerializedName("id")
    private int id;
    @SerializedName("avatar_url")
    private String avatarUrl;

    public User(String login, int id, String avatarUrl) {
        super();
        this.login = login;
        this.id = id;
        this.avatarUrl = avatarUrl;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

}
