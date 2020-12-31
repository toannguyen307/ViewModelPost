package com.example.viewmodelpost.di.module

import com.example.viewmodelpost.di.qualifier.ActivityContext
import com.example.viewmodelpost.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {
    @ActivityContext
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeActivityAndroidInjector(): MainActivity

}