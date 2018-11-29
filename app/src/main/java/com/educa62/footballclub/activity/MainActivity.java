package com.educa62.footballclub.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.educa62.footballclub.R;
import com.educa62.footballclub.adapter.MainAdapter;
import com.educa62.footballclub.database.DatabaseHelper;
import com.educa62.footballclub.model.RootFootball;
import com.educa62.footballclub.network.EndPoints;
import com.educa62.footballclub.network.RestAPI;
import com.educa62.footballclub.tool.Functions;
import com.educa62.footballclub.tool.Variables;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Functions implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout srlMain;
    private RecyclerView rvMain;
    private MainAdapter mainAdapter;
    private DatabaseHelper dbMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        srlMain = findViewById(R.id.srlMain);
        rvMain = findViewById(R.id.rvMain);
        mainAdapter = new MainAdapter(this, null);
        dbMain = new DatabaseHelper(this);
        srlMain.setOnRefreshListener(this);
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        checker();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mainAdapter == null) {
            checker();
        }
    }

    @Override
    public void onRefresh() {
        checker();
    }

    private void loadData() {
        srlMain.setRefreshing(true);
        new RestAPI().getEndPoint().create(EndPoints.class).getData(Variables.API_KEY).enqueue(new Callback<RootFootball>() {
            @Override
            public void onResponse(@NonNull Call<RootFootball> call, @NonNull Response<RootFootball> response) {
                srlMain.setRefreshing(false);
                if (response.isSuccessful() && response.body() != null) {
                    dbMain.deleteTeamsItemAll();
                    for (int position = 0; position < response.body().getCount(); position++) {
                        mainAdapter = new MainAdapter(MainActivity.this, response.body().getTeams());
                        rvMain.setAdapter(mainAdapter);
                        dbMain.inputTeamsItem(response.body().getTeams().get(position));
                    }
                } else {
                    MyToast("error: " + response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<RootFootball> call, @NonNull Throwable t) {
                srlMain.setRefreshing(false);
                MyToast("failure: " + t.getMessage());
            }
        });
    }

    private void checker() {
        if (CheckConnectivity()) {
            loadData();
        } else {
            if (dbMain.getTeamsItemList() != null) {
                mainAdapter = new MainAdapter(MainActivity.this, dbMain.getTeamsItemList());
                rvMain.setAdapter(mainAdapter);
                MyToast("no connection");
            } else {
                MyToast("no connection\nno local data");
            }
        }
    }
}
