package com.codingwithmitch.daggerapp_java.di.main;

import androidx.lifecycle.ViewModel;

import com.codingwithmitch.daggerapp_java.di.ViewModelKey;
import com.codingwithmitch.daggerapp_java.ui.main.posts.PostsViewModel;
import com.codingwithmitch.daggerapp_java.ui.main.profile.ProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindProfileViewModel(ProfileViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel.class)
    public abstract ViewModel bindPostsViewModel(PostsViewModel viewModel);

}
