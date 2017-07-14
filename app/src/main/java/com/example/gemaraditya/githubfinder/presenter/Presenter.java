package com.example.gemaraditya.githubfinder.presenter;

/**
 * Created by Gema Raditya on 7/13/2017.
 */

public interface Presenter <V> {
    void attachView(V view);

    void detachView();
}
