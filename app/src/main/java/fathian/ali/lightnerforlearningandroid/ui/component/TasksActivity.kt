package fathian.ali.lightnerforlearningandroid.ui.component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fathian.ali.lightnerforlearningandroid.R
import fathian.ali.lightnerforlearningandroid.databinding.TasksActivityBinding
import fathian.ali.lightnerforlearningandroid.ui.base.BaseActivity
import java.util.*

class TasksActivity : BaseActivity() {

    private lateinit var binding: TasksActivityBinding


    override fun initializeViewModel() {

    }

    override fun observeViewModel() {

    }

    override fun initViewBinding() {
        binding = TasksActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

}