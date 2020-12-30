package fathian.ali.lightnerforlearningandroid.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import fathian.ali.lightnerforlearningandroid.data.local.dao.TaskDao
import fathian.ali.lightnerforlearningandroid.data.local.entity.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

}