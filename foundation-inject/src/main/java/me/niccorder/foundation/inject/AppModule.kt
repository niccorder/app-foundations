package me.niccorder.foundation.inject

import android.app.ActivityManager
import android.app.Application
import android.content.Context
import android.location.LocationManager
import android.net.ConnectivityManager
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    @AppScope
    fun appContext(app: Application): Context = app

    @Provides
    @AppScope
    fun activityManager(
            context: Context
    ): ActivityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

    @Provides
    @AppScope
    fun locationManager(
            context: Context
    ): LocationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    @Provides
    @AppScope
    fun networkManager(
            context: Context
    ): ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
}