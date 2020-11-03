package com.codingwithmitch.daggerapp_java;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

import com.codingwithmitch.daggerapp_java.models.User;
import com.codingwithmitch.daggerapp_java.ui.auth.AuthResource;

import javax.inject.Inject;

public class SessionManager {

    private static final String TAG = "SessionManager";

    private MediatorLiveData<AuthResource<User>> cachedUser = new MediatorLiveData<>();

    @Inject
    public SessionManager(){
    }

    public void authenticateWithId(final LiveData<AuthResource<User>> source) {
        if(cachedUser != null){
            cachedUser.setValue(AuthResource.loading(null));
            cachedUser.addSource(source, new Observer<AuthResource<User>>() {
                @Override
                public void onChanged(AuthResource<User> authResource) {
                    cachedUser.setValue(authResource);
                    cachedUser.removeSource(source);
                }
            });
        }
    }

    public void logOut(){
        Log.d(TAG, "logOut: logging out...");
        cachedUser.setValue(AuthResource.logout());
    }

    public LiveData<AuthResource<User>> getAuthUser(){
        return cachedUser;
    }


}
