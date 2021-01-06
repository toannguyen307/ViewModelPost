package com.example.viewmodelpost.di.module

import android.content.Context
import com.example.viewmodelpost.view.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ActivityContext

//@Module(includes = [MainActivityModule::class])
//@InstallIn(ApplicationComponent::class)
//abstract class ActivitiesModule {
////    @ActivityContext
////    @ContributesAndroidInjector(modules = [MainActivityModule::class])
//
//    @Binds
//    abstract fun bindActivityAndroidInjector(mainActivity: MainActivity): Context
//
//}