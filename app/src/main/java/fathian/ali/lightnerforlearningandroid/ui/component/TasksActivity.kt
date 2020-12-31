package fathian.ali.lightnerforlearningandroid.ui.component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import fathian.ali.lightnerforlearningandroid.R
import fathian.ali.lightnerforlearningandroid.data.Resource
import fathian.ali.lightnerforlearningandroid.data.Status
import fathian.ali.lightnerforlearningandroid.data.local.entity.Task
import fathian.ali.lightnerforlearningandroid.databinding.TasksActivityBinding
import fathian.ali.lightnerforlearningandroid.ui.ViewModelFactory
import fathian.ali.lightnerforlearningandroid.ui.base.BaseActivity
import fathian.ali.lightnerforlearningandroid.utils.observe
import java.util.*
import javax.inject.Inject

class TasksActivity : BaseActivity() {

    private lateinit var binding: TasksActivityBinding

    @Inject
    lateinit var tasksListViewModel: TasksViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
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
    }

    override fun observeViewModel() {
        observe(tasksListViewModel.getTasks(), ::handleRecipesList)
    }

    private fun handleRecipesList(tasks: Resource<List<Task>>) {
        when (tasks.status) {
            Status.LOADING -> showLoadingView()
            Status.SUCCESS -> tasks.data?.let { bindListData(tasks = it) }
            Status.ERROR -> {
                showDataView(false)
                tasks.errorCode?.let { recipesListViewModel.showToastMessage(it) }
            }
        }
    }

}