package com.codingwithmitch.daggerapp_java.di;

import android.app.Application;

import com.codingwithmitch.daggerapp_java.BaseApplication;
import com.codingwithmitch.daggerapp_java.viewmodels.ViewModelProviderFactory;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton // tells the dagger that this appcomponent owns 'singleton scope'
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                ActivityBuildersModule.class,
                AppModule.class,
                ViewModelFactoryModule.class,  // declare in AppComponent cause every viewModel is gonna be injected this module.
        }
)
public interface AppComponent extends AndroidInjector<BaseApplication> {



    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
