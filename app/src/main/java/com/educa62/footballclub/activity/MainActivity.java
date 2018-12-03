package com.educa62.footballclub.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.educa62.footballclub.R;
import com.educa62.footballclub.adapter.MainAdapter;
import com.educa62.footballclub.database.DatabaseHelper;
import com.educa62.footballclub.model.RootFootball;
import com.educa62.footballclub.network.EndPoints;
import com.educa62.footballclub.network.RestAPI;
import com.educa62.footballclub.tool.Presenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, Presenter.View {

    private SwipeRefreshLayout srlMain;
    private RecyclerView rvMain;
    private MainAdapter mainAdapter;
    private DatabaseHelper dbMain;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        srlMain = findViewById(R.id.srlMain);
        rvMain = findViewById(R.id.rvMain);

        /* inisialisasi kelas MainAdapter DatabaseHelper Presenter */
        mainAdapter = new MainAdapter(this, null);
        dbMain = new DatabaseHelper(this);
        presenter = new Presenter();


        srlMain.setOnRefreshListener(this);
        rvMain.setLayoutManager(new LinearLayoutManager(this));

        /* Cek ketersediaan koneksi internet */
        checkConnectivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mainAdapter == null) {
            checkConnectivity(this);
        }
    }

    @Override
    public void onRefresh() {
        checkConnectivity(this);
    }

    @Override
    public void loadData(final Context context) {
        srlMain.setRefreshing(true);

        /* Coba mengambil nilai balik dengan Retrofit2 dengan @Query s=Soccer dan c=England */
        new RestAPI().getEndPoint().create(EndPoints.class).getData("Soccer", "England").enqueue(new Callback<RootFootball>() {
            @Override
            public void onResponse(@NonNull Call<RootFootball> call, @NonNull Response<RootFootball> response) {
                srlMain.setRefreshing(false);

                /* Jika respon sukses dan tidak null hapus database SQLite yg ada */
                if (response.isSuccessful() && response.body() != null) {
                    dbMain.deleteTeamsItemAll();
                    for (int position = 0; position < response.body().getTeams().size(); position++) {

                        /* Masukkan nilai yg baru didapat dari Callback ke dalam RecyclerView sekaligus ke dalam database SQLite baru */
                        mainAdapter = new MainAdapter(context, response.body().getTeams());
                        rvMain.setAdapter(mainAdapter);
                        dbMain.inputTeamsItem(response.body().getTeams().get(position));
                    }
                } else {
                    presenter.MyLog("error: " + response.body());
                    presenter.MyToast(context, "error: " + response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<RootFootball> call, @NonNull Throwable t) {
                srlMain.setRefreshing(false);
                presenter.MyLog("failure: " + t.getMessage());
                presenter.MyToast(context, "failure: " + t.getMessage());
            }
        });
    }

    @Override
    public void checkConnectivity(Context context) {

        /* Jika internet tersedia maka lakukan pengambilan data dari server */
        if (presenter.CheckConnectivity(context)) {
            loadData(context);
        } else {

            /* Jika internet tidak tersedia cek jika ada data didalam database lokal maka masukkan data lokal ke RecyclerView */
            srlMain.setRefreshing(false);
            if (dbMain.getTeamsItemList() != null) {
                mainAdapter = new MainAdapter(context, dbMain.getTeamsItemList());
                rvMain.setAdapter(mainAdapter);
                presenter.MyToast(context, "no connection");
            } else {
                presenter.MyToast(context, "no connection\nno local data");
            }
        }
    }
}
