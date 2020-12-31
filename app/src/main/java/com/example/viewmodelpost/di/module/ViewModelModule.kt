package com.example.viewmodelpost.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelpost.viewmodel.PostViewModel
import com.example.viewmodelpost.di.ViewModelFactory
import com.example.viewmodelpost.di.qualifier.ViewModelKey
import com.example.viewmodelpost.repository.PostsRepository
import com.example.viewmodelpost.repository.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel::class)
    abstract fun bindsPostViewModel(postViewModel: PostViewModel): ViewModel

}