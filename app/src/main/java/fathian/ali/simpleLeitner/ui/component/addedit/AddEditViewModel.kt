package fathian.ali.simpleLeitner.ui.component.addedit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fathian.ali.simpleLeitner.data.Resource
import fathian.ali.simpleLeitner.data.local.DatabaseHelper
import fathian.ali.simpleLeitner.data.local.entity.Task
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class AddEditViewModel @Inject constructor(private val databaseHelper: DatabaseHelper) :
    ViewModel() {

    private val taskAdded = MutableLiveData<Resource<Boolean>>()

    fun addTask(name: String, description: String) {
        viewModelScope.launch {
            if (name.isNotBlank()) {
                val task =
                    Task(name = name, description = description, box = 1, lastRead = Date().time)
                databaseHelper.insert(task)
                taskAdded.postValue(Resource.success(true))
            } else {
                taskAdded.postValue(Resource.error("Enter Title", false))
            }
        }

    }

    fun taskAdded() = taskAdded
}