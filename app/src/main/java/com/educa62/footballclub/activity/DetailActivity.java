package com.educa62.footballclub.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.educa62.footballclub.R;
import com.educa62.footballclub.tool.Variables;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ActionBar abDetail = getSupportActionBar();
        TextView tvDetail = findViewById(R.id.tvDetail);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && abDetail != null) {
            abDetail.setTitle(bundle.getString(Variables.strTeam));
            tvDetail.setText(bundle.getString(Variables.strDescriptionEN));
        } else {
            onBackPressed();
        }
    }
}
