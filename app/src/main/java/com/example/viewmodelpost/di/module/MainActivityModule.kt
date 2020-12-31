package com.example.viewmodelpost.di.module

import com.example.viewmodelpost.view.DetailPostFragment
import com.example.viewmodelpost.view.PostFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector
    abstract fun contributePostFragment(): PostFragment

    @ContributesAndroidInjector
    abstract fun contributeDetailPostFragment(): DetailPostFragment
}