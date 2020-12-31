package com.example.viewmodelpost.di.module

import android.app.Application
import android.net.Network
import com.example.viewmodelpost.repository.PostsRepository
import com.example.viewmodelpost.repository.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
abstract class NetworkModule {

    companion object{
        @Provides
        @Singleton
        fun provideRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

//        @Provides
//        @Singleton
//        fun providePostRepository(dataSource: RepositoryImpl): PostsRepository {
//            return dataSource
//        }
    }

    @Binds
    @Singleton
    abstract fun providePostRepository(source: RepositoryImpl) : PostsRepository
}