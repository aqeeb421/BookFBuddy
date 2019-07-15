package com.example.bookfbuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class ViewPostActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_post);

        mToolbar = findViewById(R.id.viewpost_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("View Posts");
    }
}
