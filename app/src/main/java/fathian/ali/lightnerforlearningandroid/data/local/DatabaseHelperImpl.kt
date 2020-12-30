package fathian.ali.lightnerforlearningandroid.data.local

import fathian.ali.lightnerforlearningandroid.data.local.entity.Task

class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {

    override suspend fun getTasks(): List<Task> = appDatabase.taskDao().getAll()

    override suspend fun insertAll(tasks: List<Task>) = appDatabase.taskDao().insertAll(tasks)

    override suspend fun delete(task: Task) {
        appDatabase.taskDao().delete(task)
    }

}