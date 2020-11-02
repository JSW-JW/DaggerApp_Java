package com.codingwithmitch.daggerapp_java.di;

import com.codingwithmitch.daggerapp_java.di.auth.AuthModule;
import com.codingwithmitch.daggerapp_java.di.auth.AuthViewModelsModule;
import com.codingwithmitch.daggerapp_java.ui.auth.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {AuthViewModelsModule.class, AuthModule.class}
    )  // declare AuthActivity as a potential client for injection(AuthActivity is AuthActivitySubComponent = AuthComponent)
    abstract AuthActivity contributeAuthActivity(); // if you have 10 activities, should add 10 annotations like this.

}
