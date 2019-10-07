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
       
        String title = bundle.getString(Variables.strTeam);
        String txtDetail = bundle.getString(Variables.strDescriptionEN);
        
        if (bundle != null && abDetail != null) {
            abDetail.setTitle(title);
            tvDetail.setText(txtDetail);
        } else {
            onBackPressed();
        }
    }
}
