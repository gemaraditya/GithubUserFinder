package com.example.gemaraditya.githubfinder.view.widget;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Gema Raditya on 7/13/2017.
 */

public class LoadingDialogBuilder {
    private LoadingDialogBuilder(){
        // Private constructor
    }

    public static ProgressDialog getIndeterminateProgressDialog(Context context, String message){
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(message);
        progressDialog.setIndeterminate(true);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }
}
