package com.codingwithmitch.daggerapp_java.di;

import com.codingwithmitch.daggerapp_java.AuthActivity;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract AuthActivity contributeAuthActivity(); // if you have 10 activities, should add 10 annotations like this.

    @Provides
    static String someString(){
        return "this is a test string";
    }  // test sample
}
