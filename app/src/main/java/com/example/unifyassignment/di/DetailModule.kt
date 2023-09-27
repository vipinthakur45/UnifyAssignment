package com.example.unifyassignment.di

import android.content.Context
import com.example.unifyassignment.domain.DetailRepositoryImpl
import com.example.unifyassignment.domain.DetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DetailModule {

    @Provides
    @Singleton
    fun provideDetailRepoImpl(@ApplicationContext context: Context): DetailsRepository {
        return DetailRepositoryImpl(context)
    }
}