package com.example.todolist.adapters


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.model.Task
import kotlinx.android.synthetic.main.item_task.view.*

class TaskAdapter(val listener: TaskAdapterListener) :
    RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    private val tasks = Task.example()

    fun add(task: Task): Int {
        val position = 0
        tasks.add(position, task)
        notifyItemInserted(position)
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_task, parent, false)
        )

    override fun getItemCount() = tasks.size

    fun check(task: Task):Int{
        val position = tasks.indexOf(task)
        task.status = !task.status ;
        tasks.set(position,task)
        notifyItemChanged(position)
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = tasks[position]
        holder.fillView(person)
//        Log.d("onBindViewHolder", person.firstName) // You'll see it only when you scroll
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun fillView(task: Task) {
            itemView.lbTitle.text = task.title
            itemView.lbDescription.text = task.description
            itemView.lbStatus.text = if (task.status) "Concluída" else "Não Realizada"

            itemView.setOnClickListener {
                listener.onTaskSelected(task)
            }
            itemView.setOnLongClickListener {
                listener.onTaskLongSelected(task)
            }
        }
    }
}