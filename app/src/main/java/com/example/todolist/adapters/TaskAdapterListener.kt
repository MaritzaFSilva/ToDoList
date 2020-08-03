package com.example.todolist.adapters

import com.example.todolist.model.Task

interface TaskAdapterListener {
        fun onTaskSelected(task: Task)
        fun onTaskLongSelected(task: Task): Boolean
//        fun taskSaved(task: Task)
//        fun taskRemoved(task: Task)
}