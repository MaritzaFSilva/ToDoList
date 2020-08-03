package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.adapters.TaskAdapter
import com.example.todolist.adapters.TaskAdapterListener
import com.example.todolist.model.Task
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TaskAdapterListener {
    private lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ckStatus.setVisibility(INVISIBLE)
        adapter = TaskAdapter(this)
        listPeople.adapter = adapter
        listPeople.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        btSave.setOnClickListener {
            val task = Task(
                (0..10000).random(),
                txtTitle.text.toString(),
                txtDescription.text.toString(),
                ckStatus.isChecked
            )
            val position = adapter.add(task)
            (listPeople.layoutManager as LinearLayoutManager).scrollToPosition(position)

        }
    }

    override fun onTaskSelected(task: Task) {
        txtTitle.setText(task.title)
        txtDescription.setText(task.description)
        ckStatus.setVisibility(VISIBLE)
        ckStatus.setChecked(task.status)
    }

    override fun onTaskLongSelected(task: Task): Boolean {
        adapter.check(task)
        return true
    }


}