package com.educa62.footballclub.tool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.Objects;

@SuppressLint("Registered")
public class Functions extends AppCompatActivity {

    protected void MyToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    protected boolean CheckConnectivity() {
        NetworkInfo info = ((ConnectivityManager) Objects.requireNonNull(this.getSystemService(Context.CONNECTIVITY_SERVICE))).getActiveNetworkInfo();
        return (info != null && info.isConnected() && info.isAvailable());
    }
}
