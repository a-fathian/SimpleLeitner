package fathian.ali.lightnerforlearningandroid.data.local.entity

import androidx.room.Entity
import java.util.*

@Entity
data class Task(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val description: String,
    val box: Int,
    val lastRead: Long
)