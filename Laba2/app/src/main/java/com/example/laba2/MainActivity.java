package com.example.laba2;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

    EditText et_Name;
    EditText et_LName;
    EditText et_Phone;
    Button btnSubmit;

    SharedPreferences sName;
    SharedPreferences sLName;
    SharedPreferences sPhone;

    final String SAVED_TEXT = "saved_text";
    final String SAVED = "saved";
    final String TEXT = "text";

    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_Name = (EditText) findViewById(R.id.et_Name);
        et_LName = (EditText) findViewById(R.id.et_LName);
        et_Phone = (EditText) findViewById(R.id.et_Phone);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
        loadText();
        if (et_Name.getText().length() > 1 && et_LName.getText().length() > 1 && et_Phone.getText().length() > 1) {
            btnSubmit.setText("Log in");
        }
        Log.d(TAG, "MainActivity: onCreate");
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("et_Name", et_Name.getText().toString());
        intent.putExtra("et_LName", et_LName.getText().toString());
        intent.putExtra("et_Phone", et_Phone.getText().toString());
        startActivity(intent);
        switch (v.getId()) {
            case R.id.btnSubmit:
                saveText();
            default:
                break;
        }
        Log.d(TAG, "MainActivity: onClick");
    }

    void saveText() {
        sName = getPreferences(MODE_PRIVATE);
        Editor info1 = sName.edit();
        sLName = getPreferences(MODE_PRIVATE);
        Editor info2 = sLName.edit();
        sPhone = getPreferences(MODE_PRIVATE);
        Editor info3 = sPhone.edit();
        info1.putString(SAVED_TEXT, et_Name.getText().toString());
        info2.putString(SAVED, et_LName.getText().toString());
        info3.putString(TEXT, et_Phone.getText().toString());
        info1.commit();
        info2.commit();
        info3.commit();
        Log.d(TAG, "MainActivity: saveText");
    }

    void loadText() {
        sName = getPreferences(MODE_PRIVATE);
        String savedText = sName.getString(SAVED_TEXT, "");
        sLName = getPreferences(MODE_PRIVATE);
        String saved = sLName.getString(SAVED, "");
        sPhone = getPreferences(MODE_PRIVATE);
        String Text = sPhone.getString(TEXT, "");
        et_Name.setText(savedText);
        et_LName.setText(saved);
        et_Phone.setText(Text);
        Log.d(TAG, "MainActivity: loadText");
    }

}
