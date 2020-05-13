package com.lotik2021.simplemvvm.di.module

import com.lotik2021.simplemvvm.ui.first.FirstFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentBuilder {

    @ContributesAndroidInjector(modules = [ViewmodelBuilder::class])
    fun contributeFirstFragment(): FirstFragment

}