package com.hansheung.mob132

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: TodoAdapter
    private val tasks = Task.generateTask(1).toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupAdapter()

        findViewById<FloatingActionButton>(R.id.fabAdd).setOnClickListener{
            addTask()
        }
    }

    private fun addTask(){
         val task = (1..1000).random().let{
             Task(title = "Random Title $it", desc = "Random Description $it")
         }
        tasks.add(task)

        adapter.setTasks(tasks)

        Log.d("debugging", tasks.toString())

    }

    private fun setupAdapter(){
        adapter = TodoAdapter(tasks)
        val recylerView = findViewById<RecyclerView>(R.id.rvTasks)

        recylerView.adapter = adapter
        recylerView.layoutManager = LinearLayoutManager(this)
    }
}