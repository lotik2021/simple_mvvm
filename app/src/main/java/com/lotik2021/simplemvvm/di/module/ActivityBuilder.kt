package com.lotik2021.simplemvvm.di.module

import com.lotik2021.simplemvvm.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            ActivityModule::class,
            FragmentBuilder::class
        ]
    )
    fun contributeMainActivity(): MainActivity

}