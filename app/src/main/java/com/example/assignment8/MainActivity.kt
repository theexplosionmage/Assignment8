package com.example.assignment8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import assignment8.R
import com.example.assignment8.adapter.Adapter
import com.example.retrofittest.Factory
import com.example.assignment8.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: Model
    private val myAdapter by lazy { Adapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerview()

        val repository = Repository()
        val viewModelFactory = Factory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(Model::class.java)
        viewModel.getCustomPosts(5,"id", "desc")
        viewModel.myCustomPosts.observe(this, Observer { response ->
            if(response.isSuccessful){
                response.body()?.let { myAdapter.setData(it) }
            }else {
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun setupRecyclerview() {
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

}