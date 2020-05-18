package com.daria.example2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private CheckBox addToBackStackCb;

    private Fragment1 fragment1 = new Fragment1();
    private Fragment2 fragment2 = new Fragment2();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addReplaceBtn = findViewById(R.id.btnAddReplace);
        Button removeBtn = findViewById(R.id.btnRemove);

        addReplaceBtn.setOnClickListener(this);
        removeBtn.setOnClickListener(this);

        addToBackStackCb = findViewById(R.id.cbAddToBackStack);
    }

    @Override
    public void onClick(View v) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        Fragment fragment = manager.findFragmentById(R.id.container);

        switch (v.getId()) {
            case R.id.btnAddReplace:
                if (fragment == null) {
                    transaction.add(R.id.container, fragment1);
                } else if (fragment instanceof Fragment1) {
                    transaction.replace(R.id.container, fragment2);
                } else if (fragment instanceof Fragment2) {
                    transaction.replace(R.id.container, fragment1);
                }
                break;
            case R.id.btnRemove:
                if (fragment != null) {
                    transaction.remove(fragment);
                }
                break;
        }

        if (addToBackStackCb.isChecked()) {
            transaction.addToBackStack(null);
        }

        transaction.commit();
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
