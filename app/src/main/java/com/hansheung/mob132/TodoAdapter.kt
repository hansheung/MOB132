package com.hansheung.mob132

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/*
To render any item we need xml design,
We need a viewholder which is recycler view holder
also an adapter to operate on a list
 */

class TodoAdapter(
    private var tasks: List<Task>
): RecyclerView.Adapter<TodoAdapter.TaskViewHolder>() {

    //We need a method that will create a view from the xml design
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout_task,
            parent,
            false
        )
        return TaskViewHolder(view)
    }
    //Method to show the data inside the view holder
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        val titleText = holder.itemView.findViewById<TextView>(R.id.tvTitle)
        val descText = holder.itemView.findViewById<TextView>(R.id.tvDesc)

        titleText.text = task.title
        descText.text = task.desc

    }
    //To know the size of the list
    override fun getItemCount() = tasks.size

    fun setTasks(tasks: List<Task>){
        this.tasks = tasks
        notifyDataSetChanged()
    }

    class TaskViewHolder(view: View): RecyclerView.ViewHolder(view)
}