package fathian.ali.lightnerforlearningandroid.ui.component

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fathian.ali.lightnerforlearningandroid.data.Resource
import fathian.ali.lightnerforlearningandroid.data.local.DatabaseHelper
import fathian.ali.lightnerforlearningandroid.data.local.entity.Task
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout
import java.lang.Exception

class TasksViewModel(private val databaseHelper: DatabaseHelper): ViewModel() {

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