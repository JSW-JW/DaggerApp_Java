package com.codingwithmitch.daggerapp_java.di.main;

import android.app.Application;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.codingwithmitch.daggerapp_java.network.main.MainApi;
import com.codingwithmitch.daggerapp_java.ui.main.posts.PostsRecyclerAdapter;
import com.codingwithmitch.daggerapp_java.util.VerticalSpacingItemDecoration;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MainModule {

    @Provides
    static LinearLayoutManager provideLayoutManager(Application application){
        return new LinearLayoutManager(application);
    }

    @Provides
    static VerticalSpacingItemDecoration provideDecoration(){
        return new VerticalSpacingItemDecoration(15);
    }

    @Provides
    static PostsRecyclerAdapter provideAdapter(){
        return new PostsRecyclerAdapter();
    }

    @Provides
    static MainApi provideMainApi(Retrofit retrofit){
        return retrofit.create(MainApi.class);
    }
}
