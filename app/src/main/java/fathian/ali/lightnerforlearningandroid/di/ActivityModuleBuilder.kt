package fathian.ali.lightnerforlearningandroid.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import fathian.ali.lightnerforlearningandroid.ui.component.TasksActivity

@Suppress("unused")
@Module
abstract class ActivityModuleBuilder {

    @ContributesAndroidInjector()
    abstract fun contributeTasksActivity(): TasksActivity

}
