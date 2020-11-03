package com.codingwithmitch.daggerapp_java.ui.main.posts;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.codingwithmitch.daggerapp_java.SessionManager;
import com.codingwithmitch.daggerapp_java.network.main.MainApi;

import javax.inject.Inject;

public class PostsViewModel extends ViewModel {

    private static final String TAG = "PostsViewModel";

    // inject
    private final SessionManager sessionManager;
    private final MainApi mainApi;

    @Inject
    public PostsViewModel(SessionManager sessionManager, MainApi mainApi) {
        this.sessionManager = sessionManager;
        this.mainApi = mainApi;
        Log.d(TAG, "PostsViewModel: view model is working...");
    }
}
