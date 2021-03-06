package fathian.ali.simpleLeitner.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import fathian.ali.simpleLeitner.ui.ViewModelFactory
import fathian.ali.simpleLeitner.ui.component.addedit.AddEditViewModel
import fathian.ali.simpleLeitner.ui.component.tasks.TasksViewModel

/**
 * Since dagger
 * support multibinding you are free to bind as may ViewModels as you want.
 */
@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(TasksViewModel::class)
    abstract fun bindTasksViewModel(viewModel: TasksViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddEditViewModel::class)
    abstract fun bindAddEditViewModel(viewModel: AddEditViewModel): ViewModel

}
