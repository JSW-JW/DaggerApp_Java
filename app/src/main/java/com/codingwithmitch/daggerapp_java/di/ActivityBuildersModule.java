package com.codingwithmitch.daggerapp_java.di;

import com.codingwithmitch.daggerapp_java.di.auth.AuthModule;
import com.codingwithmitch.daggerapp_java.di.auth.AuthViewModelsModule;
import com.codingwithmitch.daggerapp_java.di.main.MainFragmentBuildersModule;
import com.codingwithmitch.daggerapp_java.ui.auth.AuthActivity;
import com.codingwithmitch.daggerapp_java.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {AuthViewModelsModule.class, AuthModule.class}
    )  // declare AuthActivity as a potential client for injection(AuthActivity is AuthActivitySubComponent = AuthComponent)
    abstract AuthActivity contributeAuthActivity(); // if you have 10 activities, should add 10 annotations like this.
    // When we @ContributesAndroidInjector... , this makes a subComponent and declares its modules that can only be accessible in that subComponent.

    @ContributesAndroidInjector(
            modules = {MainFragmentBuildersModule.class}
    ) // it means MainFragment can only be alive inside of the MainSubComponent scope.
    abstract MainActivity contributeMainActivity();
}
