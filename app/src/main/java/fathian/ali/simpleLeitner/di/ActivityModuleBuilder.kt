package fathian.ali.simpleLeitner.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import fathian.ali.simpleLeitner.ui.component.addedit.AddEditActivity
import fathian.ali.simpleLeitner.ui.component.tasks.TasksActivity

@Suppress("unused")
@Module
abstract class ActivityModuleBuilder {

    @ContributesAndroidInjector()
    abstract fun contributeTasksActivity(): TasksActivity

    @ContributesAndroidInjector()
    abstract fun contributeAddEditActivity(): AddEditActivity

}
