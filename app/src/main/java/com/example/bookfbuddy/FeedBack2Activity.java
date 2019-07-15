package com.example.bookfbuddy;

import android.app.ProgressDialog;
import android.provider.Settings;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;


public class FeedBack2Activity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ActionBar actionBar;

    EditText namedata, messagedata;
    Button send, details;
    Firebase firebase;

    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back2);

        mToolbar = findViewById(R.id.feedback_page_toolbar);
        setSupportActionBar(mToolbar);
        actionBar = getSupportActionBar();
        actionBar.setTitle("Feedback and Request...");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


        namedata = findViewById(R.id.feed_name);
        messagedata = findViewById(R.id.feed_message);
        pd = new ProgressDialog(this);



        send = findViewById(R.id.btn_send);
        details = findViewById(R.id.btn_details);
        Firebase.setAndroidContext(this);


        String UniqueID = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);


        firebase = new Firebase("https://bookfbuddy.firebaseio.com/Users" + UniqueID);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Wait");
                pd.setMessage("Uploading your feedback...");
                pd.show();

                details.setEnabled(true);
                final String name = namedata.getText().toString();
                final String message = messagedata.getText().toString();


                Firebase child_name = firebase.child("Name");
                child_name.setValue(name);
                if (name.isEmpty()) {

                    namedata.setError("This is  an required field");
                    send.setEnabled(false);
                    pd.dismiss();
                } else
                {
                    namedata.setError(null);
                    send.setEnabled(true);
                    pd.dismiss();
                }

                Firebase child_message = firebase.child("Massage");
                child_message.setValue(message);
                if (name.isEmpty()) {
                    namedata.setError("this is  an required field");
                    send.setEnabled(false);

                } else
                {
                    messagedata.setError(null);
                    send.setEnabled(true);

                }

                Toast.makeText(FeedBack2Activity.this, "your data was sended to server", Toast.LENGTH_SHORT).show();


                details.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new AlertDialog.Builder(FeedBack2Activity.this)
                                .setTitle("sended details:")
                                .setMessage("name - " + name + "\n\nmessage - " + message).show();


                    }


                });

            }


        });

    }


    @Override
    public boolean onSupportNavigateUp() {
        super.onSupportNavigateUp();
        finish();
        return true;
    }
}




