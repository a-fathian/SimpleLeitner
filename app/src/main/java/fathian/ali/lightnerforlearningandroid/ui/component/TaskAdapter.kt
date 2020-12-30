package fathian.ali.lightnerforlearningandroid.ui.component

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fathian.ali.lightnerforlearningandroid.data.local.entity.Task
import fathian.ali.lightnerforlearningandroid.databinding.TaskItemBinding


class TaskAdapter(
    private val tasks: ArrayList<Task>
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    class TaskViewHolder(private val itemBinding: TaskItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(task: Task) {
            itemBinding.textViewTask.text = task.name
            itemBinding.textViewDescription.text = task.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemBinding =
            TaskItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(itemBinding)
    }


    override fun getItemCount(): Int = tasks.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) =
        holder.bind(tasks[position])

    fun addData(list: List<Task>) {
        tasks.addAll(list)
    }

}