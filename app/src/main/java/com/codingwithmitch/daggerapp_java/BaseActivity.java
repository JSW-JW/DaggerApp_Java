package com.codingwithmitch.daggerapp_java;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.codingwithmitch.daggerapp_java.models.User;
import com.codingwithmitch.daggerapp_java.ui.auth.AuthActivity;
import com.codingwithmitch.daggerapp_java.ui.auth.AuthResource;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {

    private static final String TAG = "BaseActivity";

    @Inject
    public SessionManager sessionManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subscribeObservers();
    }

    private void subscribeObservers() {
        sessionManager.getAuthUser().observe(this, new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> authResource) {
                if(authResource != null){
                    switch (authResource.status) {
                        case LOADING: {

                            break;
                        }
                        case AUTHENTICATED: {
                            Log.d(TAG, "onChanged: LOGIN SUCCESS " + authResource.data.getEmail());
                            break;
                        }
                        case ERROR: {
                            Log.e(TAG, "onChanged: " + authResource.message);

                            break;
                        }
                        case NOT_AUTHENTICATED: {
                            navLoginScreen();
                            break;
                        }
                    }
                }
            }
        });
    }

    private void navLoginScreen(){
        Intent intent = new Intent(this, AuthActivity.class);
        startActivity(intent);
        finish();
    }
}
