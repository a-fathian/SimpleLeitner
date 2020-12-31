package fathian.ali.simpleLeitner.di

import dagger.Binds
import dagger.Module
import fathian.ali.simpleLeitner.data.local.DatabaseHelper
import fathian.ali.simpleLeitner.data.local.DatabaseHelperImpl
import javax.inject.Singleton

// Tells Dagger this is a Dagger module
@Module
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun provideDatabaseHelper(database: DatabaseHelperImpl): DatabaseHelper


}
