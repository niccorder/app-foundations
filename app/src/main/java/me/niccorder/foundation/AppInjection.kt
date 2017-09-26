package me.niccorder.foundation

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import me.niccorder.foundation.inject2.AppScope
import me.niccorder.foundation.inject2.PerActivity

@AppScope
@Module(includes = arrayOf(
        AndroidSupportInjectionModule::class,
        BaseActivityInjectors::class
))
abstract class AppModule {

    @Binds
    @AppScope
    abstract fun application(application: Application): Context
}

@Module
abstract class BaseActivityInjectors {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    internal abstract fun homeActivity(): MainActivity
}

@AppScope
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        AppModule::class
))
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<BaseApplication>() {

        @BindsInstance
        abstract fun application(app: Application): Builder
    }
}