package com.educa62.footballclub.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.educa62.footballclub.R;
import com.educa62.footballclub.model.TeamsItem;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {

    private final Context mainContext;
    private final List<TeamsItem> mainTeamsItem;

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
        holder.tvItemMain.setText(mainTeamsItem.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mainContext, mainTeamsItem.get(position).getShortName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mainTeamsItem.size();
    }

    class MainHolder extends RecyclerView.ViewHolder {
        final TextView tvItemMain;

        MainHolder(View itemView) {
            super(itemView);
            tvItemMain = itemView.findViewById(R.id.tvItemMain);
        }
    }
}
