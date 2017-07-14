package com.example.gemaraditya.githubfinder.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gemaraditya.githubfinder.R;
import com.example.gemaraditya.githubfinder.model.User;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.attr.resource;

/**
 * Created by Gema Raditya on 7/11/2017.
 */

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.UserRecyclerViewHolder> {
    private Context context;
    private List<User> userList;

    public UserRecyclerAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public UserRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_list_row, parent, false);

        return new UserRecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserRecyclerViewHolder holder, int position) {
        User userResource = userList.get(position);
        holder.userNameLogin.setText(userResource.getLogin());
        if(userResource.getAvatarUrl() != null) {
            Picasso.with(context)
                    .load(userResource.getAvatarUrl())
                    .resize(200, 200)
                    .centerInside()
                    .into(holder.userAvatar);
        }
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserRecyclerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.user_name_login) TextView userNameLogin;
        @BindView(R.id.user_avatar) ImageView userAvatar;

        public UserRecyclerViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }

    }

}
