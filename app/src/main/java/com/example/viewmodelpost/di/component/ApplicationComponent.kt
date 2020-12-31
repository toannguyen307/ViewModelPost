package com.example.viewmodelpost.di.component

import com.example.viewmodelpost.di.module.ActivitiesModule
import com.example.viewmodelpost.di.module.NetworkModule
import com.example.viewmodelpost.di.module.ViewModelModule
import com.example.viewmodelpost.view.MainActivity
import com.example.viewmodelpost.view.PostFragment
import dagger.Component
import dagger.android.AndroidInjection
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ViewModelModule::class, ActivitiesModule::class])
interface ApplicationComponent {
    fun inject(postFragment: PostFragment)
    fun inject(mainActivity: MainActivity)
}