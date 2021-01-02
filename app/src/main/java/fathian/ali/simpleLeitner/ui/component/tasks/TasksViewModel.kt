package fathian.ali.simpleLeitner.ui.component.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fathian.ali.simpleLeitner.data.Resource
import fathian.ali.simpleLeitner.data.local.DatabaseHelper
import fathian.ali.simpleLeitner.data.local.entity.Task
import kotlinx.coroutines.launch
import javax.inject.Inject

class TasksViewModel @Inject constructor(private val databaseHelper: DatabaseHelper) : ViewModel() {

    val tasks = MutableLiveData<Resource<List<Task>>>()

    init {
        fetchTasks()
    }

    private fun fetchTasks() {
        viewModelScope.launch {
            tasks.value = Resource.loading(null)
            // delay(2000L)
            try {
                databaseHelper.getTasks().collect {
                    tasks.value = Resource.success(it)
                }
            } catch (e: Exception) {
                tasks.value = Resource.error("Something went wrong", null)
            }
        }
    }

    fun getTasks(): LiveData<Resource<List<Task>>> {
        fetchTasks()
        return tasks
    }

}