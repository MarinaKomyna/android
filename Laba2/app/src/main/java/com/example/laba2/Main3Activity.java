package com.example.laba2;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;

public class Main3Activity extends Activity implements OnClickListener {

    EditText et_Street;
    EditText et_Home;
    EditText et_FLat;
    EditText et_toStreet;
    EditText et_toHome;
    EditText et_toFLat;
    Button btnOK;

    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        et_Street = (EditText) findViewById(R.id.et_Street);
        et_Home = (EditText) findViewById(R.id.et_Home);
        et_FLat = (EditText) findViewById(R.id.et_FLat);
        et_toStreet = (EditText) findViewById(R.id.et_toStreet);
        et_toHome = (EditText) findViewById(R.id.et_toHome);
        et_toFLat = (EditText) findViewById(R.id.et_toFLat);

        btnOK = (Button) findViewById(R.id.btnOK);
        btnOK.setOnClickListener(this);

        Log.d(TAG, "Main3Activity: onCreate");
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("et_Street", et_Street.getText().toString());
        intent.putExtra("et_Home", et_Home.getText().toString());
        intent.putExtra("et_FLat", et_FLat.getText().toString());
        intent.putExtra("et_toStreet", et_toStreet.getText().toString());
        intent.putExtra("et_toHome", et_toHome.getText().toString());
        intent.putExtra("et_toFLat", et_toFLat.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
        Log.d(TAG, "Main3Activity: onClick");
    }
}
