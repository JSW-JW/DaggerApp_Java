package com.codingwithmitch.daggerapp_java.ui.main.profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.codingwithmitch.daggerapp_java.R;
import com.codingwithmitch.daggerapp_java.models.User;
import com.codingwithmitch.daggerapp_java.ui.auth.AuthResource;
import com.codingwithmitch.daggerapp_java.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class ProfileFragment extends DaggerFragment {

    private static final String TAG = "ProfileFragment";

    private ProfileViewModel viewModel;
    private TextView email, username, website;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated: ProfileFragment was created...");
        email = view.findViewById(R.id.email);
        username = view.findViewById(R.id.username);
        website = view.findViewById(R.id.website);

        viewModel = new ViewModelProvider(this, providerFactory).get(ProfileViewModel.class);

     /*   AuthResource<User> user = ((MainActivity)getActivity()).sessionManager.getAuthUser().getValue();

     * -------------------- The reason why we should't retrieve User Object like this? -------------
     * It breaks the MVVM architecture. The whole point of using live data is making the data aware
     * of lifecycle. So it's basically immune to configuration changes or any other small things.
     * In case of this example, every time the view is created, user object is updated and there is
     * possibility that it can be null. It will crash our app. */

    }

    private void subscribeObservers(){
        viewModel.getAuthenticatedUser().removeObservers(getViewLifecycleOwner()); /* Fragment has its own lifecycle. This is why
        we need to remove the observer. Otherwise, we will get kind of weird behavior like observers left floating around memory. */

        viewModel.getAuthenticatedUser().observe(getViewLifecycleOwner(), new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> authResource) {
                if(authResource != null) {
                    switch (authResource.status) {
                        case AUTHENTICATED:{
                            setUserDetails(authResource.data);
                            break;
                        }
                        case ERROR:{
                            setErrorDetails(authResource.message);
                            break;
                        }
                    }
                }
            }
        });
    }

    private void setErrorDetails(String message) {
        email.setText(message);
        username.setText("error");
        website.setText("error");
    }

    private void setUserDetails(User data) {
        email.setText(data.getEmail());
        username.setText(data.getUsername());
        website.setText(data.getWebsite());
    }
}
