package fathian.ali.simpleLeitner.di

import dagger.Module
import dagger.Provides
import fathian.ali.simpleLeitner.App
import fathian.ali.simpleLeitner.data.local.AppDatabase
import fathian.ali.simpleLeitner.data.local.DatabaseBuilder
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
