package com.example.tablo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Integer chelsea = 0;
    private Integer liver = 0;
    private TextView chelseaTextView;
    private TextView liverTextView;
    private static final String TAG = "MainActivity";

    @Override
    protected void onResume() {
        super.onResume();
        resetUI();
        Toast.makeText(this, "onResume()", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chelseaTextView = findViewById(R.id.num_1);
        liverTextView = findViewById(R.id.num_2);
        Toast.makeText(this, "onCreate()", Toast.LENGTH_LONG).show();
    }

    public void onClickAddMeteor(View view) {
        chelsea++;
        chelseaTextView.setText(chelsea.toString());
    }

    public void onClickAddPennant(View view) {
        liver++;
        liverTextView.setText(liver.toString());
    }

    public void onClickButtonDropping(View view) {
        chelsea = 0;
        liver = 0;
        resetUI();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("meteor", chelsea);
        outState.putInt("pennant", liver);

        TextView counterView = findViewById(R.id.num_1);
        counterView.setText(chelsea.toString());
        Toast.makeText(this, "onSaveInstanceState()", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("meteor")) {
            chelsea = savedInstanceState.getInt("meteor");
        }
        if ((savedInstanceState != null && savedInstanceState.containsKey("pennant"))) {
            liver = savedInstanceState.getInt("pennant");
        }
        TextView counterView = findViewById(R.id.num_1);
        counterView.setText(chelsea.toString());
        Toast.makeText(this, "onRestoreInstanceState()", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onRestoreInstanceState");
    }
    private void resetUI() {
        chelseaTextView.setText(chelsea.toString());
        liverTextView.setText(liver.toString());
        Toast.makeText(this, "resetUI()", Toast.LENGTH_LONG).show();
        Log.d(TAG, "resetUI");
    }

}