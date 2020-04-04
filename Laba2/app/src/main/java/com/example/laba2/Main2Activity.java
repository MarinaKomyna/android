package com.example.laba2;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends Activity implements View.OnClickListener {
    TextView name;
    TextView phone;
    TextView taxi;
    Button btnSubmit2;
    Button btnCallTaxi;

    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = (TextView) findViewById(R.id.name);
        phone = (TextView) findViewById(R.id.phone);
        Intent intent = getIntent();
        String et_Name = intent.getStringExtra("et_Name");
        String et_LName = intent.getStringExtra("et_LName");
        String et_Phone = intent.getStringExtra("et_Phone");
        name.setText(et_Name + " " + et_LName);
        phone.setText(et_Phone);
        taxi = (TextView) findViewById(R.id.taxi);
        btnSubmit2 = (Button) findViewById(R.id.btnSubmit2);
        btnSubmit2.setOnClickListener(this);
        btnCallTaxi= findViewById(R.id.btnCallTaxi);
        btnCallTaxi.setEnabled(false);
        Log.d(TAG, "Main2Activity: onCreate");
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Main3Activity.class);
        startActivityForResult(intent, 1);
        btnCallTaxi.setEnabled(true);
        Log.d(TAG, "Main2Activity: onClick");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            return;
        }
        String et_Street = data.getStringExtra("et_Street");
        String et_Home = data.getStringExtra("et_Home");
        String et_FLat = data.getStringExtra("et_FLat");
        String et_toStreet = data.getStringExtra("et_toStreet");
        String et_toHome = data.getStringExtra("et_toHome");
        String et_toFLat = data.getStringExtra("et_toFLat");
        taxi.setText("Taxi will arrive at " + et_Street + ", " + et_Home + ", " + et_FLat + " in 5 minutes and take you in " + et_toStreet + ", " + et_toHome + ", " + et_toFLat + ". If you are agree click Call Taxi.");
        Log.d(TAG, "Main2Activity: onActivityResult");
    }

    public void showToast(View view) {
       Toast toast = Toast.makeText(getApplicationContext(), "Wait for Taxi. Good Luck!", Toast.LENGTH_SHORT);
        toast.show();
        Log.d(TAG, "Main2Activity: showToast");
    }
}
