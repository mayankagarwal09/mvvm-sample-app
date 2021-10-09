package com.example.mvvmsampleapp.di.module

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmsampleapp.adapters.ItemAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ActivityContext

@Module
@InstallIn(FragmentComponent::class)
class FragmentModule {

    @Provides
    fun provideLinearLayoutManager(@ActivityContext context: Context): LinearLayoutManager {
        return LinearLayoutManager(context)
    }

    @Provides
    fun provideGridLayoutManager(@ActivityContext context: Context): GridLayoutManager {
        return GridLayoutManager(context, 3)
    }

    @com.example.mvvmsampleapp.di.qualifiers.LinearAdapter
    @Provides
    fun provideLinearItemAdapter(layoutManager: LinearLayoutManager): ItemAdapter {
        return ItemAdapter(layoutManager)
    }

    @com.example.mvvmsampleapp.di.qualifiers.GridAdapter
    @Provides
    fun provideGridItemAdapter(layoutManager: GridLayoutManager): ItemAdapter {
        return ItemAdapter(layoutManager)
    }
}