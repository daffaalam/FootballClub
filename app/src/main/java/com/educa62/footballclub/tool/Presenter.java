package com.educa62.footballclub.tool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import java.util.Objects;

@SuppressLint("Registered")
public class Presenter {

    public void MyLog(String message) {
        Log.v("MyLOG", message);
    }

    public void MyToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public boolean CheckConnectivity(Context context) {
        NetworkInfo info = ((ConnectivityManager) Objects.requireNonNull(context.getSystemService(Context.CONNECTIVITY_SERVICE))).getActiveNetworkInfo();
        return (info != null && info.isConnected());
    }

    public interface View {
        void loadData(Context context);
        void checkConnectivity(Context context);
    }
}
