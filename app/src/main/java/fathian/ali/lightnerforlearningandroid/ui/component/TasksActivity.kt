package fathian.ali.lightnerforlearningandroid.ui.component

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import fathian.ali.lightnerforlearningandroid.R
import fathian.ali.lightnerforlearningandroid.data.Resource
import fathian.ali.lightnerforlearningandroid.data.Status
import fathian.ali.lightnerforlearningandroid.data.local.entity.Task
import fathian.ali.lightnerforlearningandroid.databinding.TasksActivityBinding
import fathian.ali.lightnerforlearningandroid.ui.ViewModelFactory
import fathian.ali.lightnerforlearningandroid.ui.base.BaseActivity
import fathian.ali.lightnerforlearningandroid.utils.observe
import fathian.ali.lightnerforlearningandroid.utils.*
import javax.inject.Inject

class TasksActivity : BaseActivity() {

    private lateinit var binding: TasksActivityBinding

    lateinit var tasksListViewModel: TasksViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var tasksAdapter: TaskAdapter

    override fun initializeViewModel() {
        tasksListViewModel = viewModelFactory.create(TasksViewModel::class.java)
    }


    override fun initViewBinding() {
        binding = TasksActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = getString(R.string.tasks)
        val layoutManager = LinearLayoutManager(this)
        binding.rvTasksList.layoutManager = layoutManager
        binding.rvTasksList.setHasFixedSize(true)
        binding.rvTasksList.adapter = TaskAdapter(arrayListOf())
    }

    override fun observeViewModel() {
        observe(tasksListViewModel.getTasks(), ::handleTaskList)
    }

    private fun handleTaskList(tasks: Resource<List<Task>>) {
        when (tasks.status) {
            Status.LOADING -> showLoadingView()
            Status.SUCCESS -> tasks.data?.let { bindListData(tasks = it) }
            Status.ERROR -> {
                showDataView(false)
                tasks.message?.let { toast(it) }
            }
        }
    }

    private fun bindListData(tasks: List<Task>) {
        if (!(tasks.isNullOrEmpty())) {
            tasksAdapter.addData(tasks)
            tasksAdapter.notifyDataSetChanged()
            showDataView(true)
        } else {
            showDataView(false)
        }
    }

    private fun showLoadingView() {
        binding.pbLoading.toVisible()
        binding.tvNoData.toGone()
        binding.rvTasksList.toGone()
    }

    private fun showDataView(show: Boolean) {
        binding.tvNoData.visibility = if (show) View.GONE else View.VISIBLE
        binding.rvTasksList.visibility = if (show) View.VISIBLE else View.GONE
        binding.pbLoading.toGone()
    }

}