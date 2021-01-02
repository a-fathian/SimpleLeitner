package fathian.ali.simpleLeitner.ui.component.addedit

import android.view.View
import androidx.lifecycle.ViewModelProvider
import fathian.ali.simpleLeitner.data.Resource
import fathian.ali.simpleLeitner.data.Status
import fathian.ali.simpleLeitner.databinding.ActivityAddEditBinding
import fathian.ali.simpleLeitner.ui.base.BaseActivity
import fathian.ali.simpleLeitner.utils.observe
import fathian.ali.simpleLeitner.utils.toast
import javax.inject.Inject

class AddEditActivity : BaseActivity() {

    private lateinit var binding: ActivityAddEditBinding

    lateinit var addEditViewModel: AddEditViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    override fun initializeViewModel() {
        addEditViewModel = viewModelFactory.create(AddEditViewModel::class.java)
    }

    override fun observeViewModel() {
        observe(addEditViewModel.taskAdded(), ::handleAddTask)
    }

    private fun handleAddTask(result: Resource<Boolean>) {
        when (result.status) {
            Status.SUCCESS -> finish()
            Status.ERROR -> {
                result.message?.let { toast(it) }
            }
        }
    }

    override fun initViewBinding() {
        binding = ActivityAddEditBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun addTask(view: View) {
        addEditViewModel.addTask(
            binding.editTextTask.text.toString(),
            binding.editTextDescription.text.toString()
        )
    }
}