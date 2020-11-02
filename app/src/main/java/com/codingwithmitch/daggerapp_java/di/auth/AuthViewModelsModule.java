package com.codingwithmitch.daggerapp_java.di.auth;

import androidx.lifecycle.ViewModel;

import com.codingwithmitch.daggerapp_java.di.ViewModelKey;
import com.codingwithmitch.daggerapp_java.ui.auth.AuthViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class AuthViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthViewModel viewModel);
}
