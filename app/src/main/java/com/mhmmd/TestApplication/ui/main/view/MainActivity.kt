package com.mhmmd.TestApplication.ui.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mhmmd.TestApplication.R
import com.mhmmd.TestApplication.data.local.db.AppDatabase
import com.mhmmd.TestApplication.data.local.db.DbHelperImp
import com.mhmmd.TestApplication.data.remote.ApiHelper
import com.mhmmd.TestApplication.data.remote.ApiServiceImp
import com.mhmmd.TestApplication.ui.base.ViewModelFactory
import com.mhmmd.TestApplication.ui.main.adaptor.MainAdaptor
import com.mhmmd.TestApplication.ui.main.viewmodel.MainViewModel
import com.mhmmd.TestApplication.utils.Status

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var gameListAdaptor: MainAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUIelements()
        setupViewModel()
        setupObserver()
    }

    fun setupUIelements(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        gameListAdaptor = MainAdaptor(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = gameListAdaptor
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(ApiServiceImp()), DbHelperImp(AppDatabase.getDatabase(this)))
        ).get(MainViewModel::class.java)
    }

    private fun setupObserver() {
        mainViewModel.getGames().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { games ->
                        gameListAdaptor.addData(games)
                        gameListAdaptor.notifyDataSetChanged()
                    }
                }
                Status.LOADING -> {
                }
                Status.ERROR -> {
                }
            }
        })
    }

}




