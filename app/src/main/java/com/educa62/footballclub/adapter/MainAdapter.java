package com.educa62.footballclub.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.educa62.footballclub.R;
import com.educa62.footballclub.activity.DetailActivity;
import com.educa62.footballclub.model.TeamsItem;
import com.educa62.footballclub.tool.Presenter;
import com.educa62.footballclub.tool.Variables;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {

    private final Context mainContext;
    private final List<TeamsItem> mainTeamsItem;
    private final Bundle bundle = new Bundle();
    private final Presenter presenter = new Presenter();

    public MainAdapter(Context mainContext, List<TeamsItem> mainTeamsItem) {
        this.mainContext = mainContext;
        this.mainTeamsItem = mainTeamsItem;
    }

    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainHolder(LayoutInflater.from(mainContext).inflate(R.layout.item_main, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.tvItemMain.setText(mainTeamsItem.get(position).getStrTeam());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString(Variables.strTeam, mainTeamsItem.get(position).getStrTeam());
                bundle.putString(Variables.strTeamBadge, mainTeamsItem.get(position).getStrTeamBadge());
                bundle.putString(Variables.strDescriptionEN, mainTeamsItem.get(position).getStrDescriptionEN());
                mainContext.startActivity(new Intent(mainContext, DetailActivity.class).putExtras(bundle));
            }
        });

        /* Jika internet tersedia maka lakukan load image dengan Glide */
        if (presenter.CheckConnectivity(mainContext)) {
            Glide.with(mainContext).load(mainTeamsItem.get(position).getStrTeamBadge()).into(holder.ivItemMain);
        }
    }

    @Override
    public int getItemCount() {
        return mainTeamsItem.size();
    }

    class MainHolder extends RecyclerView.ViewHolder {
        final ImageView ivItemMain;
        final TextView tvItemMain;

        MainHolder(View itemView) {
            super(itemView);
            ivItemMain = itemView.findViewById(R.id.ivItemMain);
            tvItemMain = itemView.findViewById(R.id.tvItemMain);
        }
    }
}
