package com.mhmmd.TestApplication.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mhmmd.TestApplication.data.local.db.DbHelperImp
import com.mhmmd.TestApplication.data.remote.ApiHelper
import com.mhmmd.TestApplication.data.repository.MainRepository
import com.mhmmd.TestApplication.ui.main.viewmodel.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper, private val dbHelper: DbHelperImp) :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel :: class.java)){
            return MainViewModel(MainRepository(apiHelper, dbHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}