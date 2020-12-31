package fathian.ali.lightnerforlearningandroid.di

import dagger.Binds
import dagger.Module
import fathian.ali.lightnerforlearningandroid.data.local.AppDatabase
import fathian.ali.lightnerforlearningandroid.data.local.DatabaseBuilder
import fathian.ali.lightnerforlearningandroid.data.local.DatabaseHelper
import fathian.ali.lightnerforlearningandroid.data.local.DatabaseHelperImpl
import javax.inject.Singleton

// Tells Dagger this is a Dagger module
@Module
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun provideDatabaseHelper(database: DatabaseHelperImpl): DatabaseHelper


}
