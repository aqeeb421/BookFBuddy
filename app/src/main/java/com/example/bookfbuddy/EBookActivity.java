package com.example.bookfbuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class EBookActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);

        mToolbar = findViewById(R.id.ebook_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("E-Books");

    }
}
