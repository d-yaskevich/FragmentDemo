package com.daria.example3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ShowMessageInterface {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ShowMessageInterface fragment1, fragment2;
    private TextView messageTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();

        fragment1 = Fragment1.newInstance("init message");
        manager.beginTransaction().add(R.id.fragment1, (Fragment) fragment1).commit();

        fragment2 = (ShowMessageInterface) manager.findFragmentById(R.id.fragment2);

        Button fragment1Btn = findViewById(R.id.btnFragment1);
        Button fragment2Btn = findViewById(R.id.btnFragment2);

        fragment1Btn.setOnClickListener(this);
        fragment2Btn.setOnClickListener(this);

        messageTv = findViewById(R.id.tvMessage);
    }

    @Override
    public void onClick(View v) {
        ShowMessageInterface fragment = null;

        switch (v.getId()) {
            case R.id.btnFragment1:
                fragment = fragment1;
                break;
            case R.id.btnFragment2:
                fragment = fragment2;
                break;
        }

        if (fragment != null) {
            fragment.showMessage("Hello from Activity!");
        }
    }

    @Override
    public void showMessage(String message) {
        messageTv.setText(message);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }
}
