package com.example.coronaway.di

import android.app.Application
import androidx.room.Room
import com.example.coronaway.data.api.API
import com.example.coronaway.data.room.CoronavirusRoomDatabase
import com.example.coronaway.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideRestaurantApi(retrofit: Retrofit): API =
        retrofit.create(API::class.java)

    @Provides
    @Singleton
    fun provideDatabase(app: Application) : CoronavirusRoomDatabase =
        Room.databaseBuilder(app, CoronavirusRoomDatabase::class.java, "coronavirus_database")
            .build()
}