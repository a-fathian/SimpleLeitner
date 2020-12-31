package fathian.ali.lightnerforlearningandroid.di

import dagger.Module
import dagger.Provides
import fathian.ali.lightnerforlearningandroid.App
import fathian.ali.lightnerforlearningandroid.data.local.AppDatabase
import fathian.ali.lightnerforlearningandroid.data.local.DatabaseBuilder
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideCoroutineContext(): CoroutineContext {
        return Dispatchers.IO
    }

    @Provides
    @Singleton
    fun provideAppDatabase(): AppDatabase = DatabaseBuilder.getInstance(App.context)

}
