package com.example.gemaraditya.githubfinder.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Gema Raditya on 7/10/2017.
 */

public class UserResponse {
    @SerializedName("total_count")
    private int totalCount;
    @SerializedName("incomplete_results")
    private boolean incompleteResults;
    @SerializedName("items")
    private List<User> items;

    public UserResponse() {
    }

    public UserResponse(int totalCount, boolean incompleteResults, List<User> items) {
        super();
        this.totalCount = totalCount;
        this.incompleteResults = incompleteResults;
        this.items = items;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public boolean isIncompleteResults() {
        return incompleteResults;
    }

    public void setIncompleteResults(boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
    }

    public List<User> getItems() {
        return items;
    }

    public void setItems(List<User> items) {
        this.items = items;
    }
}
