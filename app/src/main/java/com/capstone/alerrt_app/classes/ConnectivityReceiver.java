package com.capstone.alerrt_app.classes;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.capstone.alerrt_app.activity.MainActivity;

public class ConnectivityReceiver extends BroadcastReceiver {
    public ConnectivityReceiver() {

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        try{
            boolean isVisible = MyApplication.isActivityVisible(); // Check if activity is visible or not

            if(isVisible){
                ConnectivityManager connectivityManager = (ConnectivityManager) context
                        .getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager
                        .getActiveNetworkInfo();

                // Check internet connection and according to state change the
                // text of activity by calling method
                if (networkInfo != null && networkInfo.isConnected()) {
                    new MainActivity().isConnected = true;
                } else {
                    new MainActivity().isConnected = false;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
