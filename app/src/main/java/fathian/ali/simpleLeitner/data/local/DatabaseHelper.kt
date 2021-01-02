package fathian.ali.simpleLeitner.data.local

import fathian.ali.simpleLeitner.data.local.entity.Task
import kotlinx.coroutines.flow.Flow


interface DatabaseHelper {

    suspend fun getTasks(): Flow<List<Task>>

    suspend fun insertAll(tasks: List<Task>)

    suspend fun insert(task: Task)

    suspend fun delete(task: Task)

}