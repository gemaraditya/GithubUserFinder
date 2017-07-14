package com.example.gemaraditya.githubfinder.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gemaraditya.githubfinder.R;
import com.example.gemaraditya.githubfinder.adapter.UserRecyclerAdapter;
import com.example.gemaraditya.githubfinder.model.User;
import com.example.gemaraditya.githubfinder.presenter.MainPresenter;
import com.example.gemaraditya.githubfinder.view.widget.LoadingDialogBuilder;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity  implements MainCallback{
    private MainPresenter mainPresenter;
    private final String pageLimit = "100";
    private final String progressText = "Searching user...";
    private String users;
    private ProgressDialog progressDialog;

    @BindView(R.id.search_query) EditText query;
    @BindView(R.id.user_recycler) RecyclerView recyclerView;
    @BindView(R.id.text_message) TextView textMessageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // initialize presenter
        mainPresenter = new MainPresenter();
        mainPresenter.attachView(this);

        // set up user list recyclerview
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this).build());

        query.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent keyEvent) {
                boolean handled = false;
                users = query.getText().toString();
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    if (!users.equals("")) {
                        //progressDialog = LoadingDialogBuilder.getIndeterminateProgressDialog(getContext(), progressText);
                        //progressDialog.show();
                        mainPresenter.searchUser(users,pageLimit);
                    }
                    handled = true;
                    hideSoftKeyboard(v);
                }

                return handled;
            }
        });

        query.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideSoftKeyboard(v);
                }
            }
        });
    }

    public void hideSoftKeyboard(View v) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void displayUsers(List<User> userList) {
        recyclerView.setVisibility(View.VISIBLE);
        textMessageView.setVisibility(View.GONE);
        recyclerView.setAdapter(new UserRecyclerAdapter(getApplicationContext(), userList));
        //progressDialog.dismiss();
    }

    @Override
    public void displayText(int textId) {
        recyclerView.setVisibility(View.GONE);
        textMessageView.setVisibility(View.VISIBLE);
        textMessageView.setText(getString(textId));
        //progressDialog.dismiss();
    }

    @Override
    protected void onDestroy() {
        mainPresenter.detachView();
        super.onDestroy();
    }

}
