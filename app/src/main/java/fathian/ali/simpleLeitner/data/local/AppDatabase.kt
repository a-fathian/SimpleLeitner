package fathian.ali.simpleLeitner.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import fathian.ali.simpleLeitner.data.local.dao.TaskDao
import fathian.ali.simpleLeitner.data.local.entity.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

}