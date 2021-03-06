package com.daria.example3;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment implements ShowMessageInterface {

    private static final String TAG = Fragment1.class.getSimpleName();

    private static final String MSG_KEY = "MSG_KEY";

    public static Fragment1 newInstance(String message) {
        Fragment1 fragment1 = new Fragment1();

        Bundle arguments = new Bundle();
        arguments.putString(MSG_KEY, message);

        fragment1.setArguments(arguments);

        return fragment1;
    }

    private TextView messageTv;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        Log.d(TAG, "onCreateView");

        messageTv = view.findViewById(R.id.tvMessage);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String msg = bundle.getString(MSG_KEY);
            showMessage(msg);
        }

        Button activityMessageBtn = view.findViewById(R.id.btnActivity);
        activityMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowMessageInterface activity = (ShowMessageInterface) getActivity();
                if (activity != null) {
                    activity.showMessage("Hello from Fragment#1!");
                }
            }
        });
        return view;
    }

    @Override
    public void showMessage(String message) {
        messageTv.setText(message);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");
    }
}
