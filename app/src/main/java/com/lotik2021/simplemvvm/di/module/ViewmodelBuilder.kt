package com.lotik2021.simplemvvm.di.module

import androidx.lifecycle.ViewModel
import com.lotik2021.simplemvvm.ui.first.FirstViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewmodelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(FirstViewModel::class)
    fun bindFirstViewModel(viewModel: FirstViewModel): ViewModel
}