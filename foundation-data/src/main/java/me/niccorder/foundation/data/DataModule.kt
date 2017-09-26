package me.niccorder.foundation.data

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class DataModule {

    @Provides
    fun gson(): Gson = Gson()

    @Provides
    fun okhttpClient(): OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(LoggingInterceptor)
            .build()

    @Provides
    fun retrofit(
            baseUrl: String,
            client: OkHttpClient
    ): Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .validateEagerly(true)
            .build()
}