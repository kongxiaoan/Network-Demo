package com.kpa.demo.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kpa.demo.R
import com.kpa.demo.data.api.ApiHelper
import com.kpa.demo.data.http.NetWorkHelper
import com.kpa.demo.data.model.Girls
import com.kpa.demo.ui.base.ViewModelFactory
import com.kpa.demo.ui.main.adapter.MainAdapter
import com.kpa.demo.ui.main.viewmodel.MainViewModel
import com.kpa.demo.utils.Status
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        setupViewModel()
        setupObserver()
    }

    private fun setupObserver() {
        mainViewModel.getGirls().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                   Status.SUCCESS -> {
                       recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        resource.data?.let { girls -> renderList(girls) }
                    }
                    Status.ERROR -> {
                        progressBar.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE
                    }
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                    }
                }
            }
        })
    }

    private fun setupViewModel() {
        mainViewModel =
            ViewModelProviders.of(this, ViewModelFactory(ApiHelper(NetWorkHelper.apiService))).get(
                MainViewModel::class.java)
    }

    private fun renderList(girls: Girls) {
        adapter.apply {
            addData(girls.girlList)
            notifyDataSetChanged()
        }
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }
}