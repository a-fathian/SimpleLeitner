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

class TasksViewModel @Inject constructor(private val databaseHelper: DatabaseHelper): ViewModel() {

    private val tasks = MutableLiveData<Resource<List<Task>>>()

    init {
        fetchTasks()
    }

    private fun fetchTasks() {
        viewModelScope.launch {
            tasks.postValue(Resource.loading(null))
            try {
                val savedTasks = databaseHelper.getTasks()
                tasks.postValue(Resource.success(savedTasks))
            } catch (e: Exception) {
                tasks.postValue(Resource.error("Something went wrong", null))
            }
        }
    }

    fun getTasks(): LiveData<Resource<List<Task>>> {
        return tasks
    }

}