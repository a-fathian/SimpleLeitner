package fathian.ali.simpleLeitner.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import fathian.ali.simpleLeitner.data.local.entity.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM task")
    suspend fun getAll(): List<Task>

    @Insert
    suspend fun insertAll(tasks: List<Task>)

    @Delete
    suspend fun delete(task: Task)

}