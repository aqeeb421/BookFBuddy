package com.example.bookfbuddy;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private FirebaseUser currentUser;
    private FirebaseAuth mAuth;

    private CardView TextBookCardView;
    private CardView EBookCardView;
    private CardView FeedbackCardView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        mToolbar = findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("BookForBuddy");

        TextBookCardView = findViewById(R.id.c1);
        EBookCardView = findViewById(R.id.c2);
        FeedbackCardView = findViewById(R.id.c3);


        TextBookCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, TextBookActivity.class));
            }
        });
        EBookCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, EBookActivity.class));
            }
        });
        FeedbackCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, FeedBack2Activity.class));
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        if (currentUser == null)
        {
            SendUserToLoginActivity();
        }
    }

    private void SendUserToLoginActivity() {

        Intent loginIntent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(loginIntent);
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);

         getMenuInflater().inflate(R.menu.options_menu, menu);
         return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.item_menu_3)
        {
            mAuth.signOut();
            SendUserToLoginActivity();
        }
        if (item.getItemId() == R.id.item_menu_2)
        {
            SendUserToFeedBackActivity();
        }
        if (item.getItemId() == R.id.item_menu_1)
        {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Contact to..");
            alertDialog.setMessage("Mr. Aqeeb H J \nMobile: 9964981164 \nemail: aqeeb.pasha.hnp@gmail.com");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }

        return true;
    }

    private void SendUserToFeedBackActivity() {
        Intent loginIntent = new Intent(MainActivity.this,FeedBack2Activity.class);
        startActivity(loginIntent);
        finish();
    }
}
