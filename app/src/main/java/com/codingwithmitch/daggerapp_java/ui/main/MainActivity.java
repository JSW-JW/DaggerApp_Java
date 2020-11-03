package com.codingwithmitch.daggerapp_java.ui.main;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.codingwithmitch.daggerapp_java.BaseActivity;
import com.codingwithmitch.daggerapp_java.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "MainActivity.", Toast.LENGTH_SHORT).show();
    }
}
