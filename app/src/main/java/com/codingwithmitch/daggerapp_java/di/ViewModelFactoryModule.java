package com.codingwithmitch.daggerapp_java.di;

import androidx.lifecycle.ViewModelProvider;

import com.codingwithmitch.daggerapp_java.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);

}
