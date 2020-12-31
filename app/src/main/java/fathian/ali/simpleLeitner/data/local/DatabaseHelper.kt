package fathian.ali.simpleLeitner.data.local

import fathian.ali.simpleLeitner.data.local.entity.Task


interface DatabaseHelper {

    suspend fun getTasks(): List<Task>

    suspend fun insertAll(tasks: List<Task>)

    suspend fun delete(task: Task)

}