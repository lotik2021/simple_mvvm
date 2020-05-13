package com.lotik2021.simplemvvm.di.component

import android.app.Application
import com.lotik2021.simplemvvm.MvvmApp
import com.lotik2021.simplemvvm.di.module.ActivityBuilder
import com.lotik2021.simplemvvm.di.module.DatabaseModule
import com.lotik2021.simplemvvm.di.module.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ViewModelFactoryModule::class,
        ActivityBuilder::class,
        DatabaseModule::class
    ]
)
interface AppComponent : AndroidInjector<MvvmApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(app: MvvmApp)
}
