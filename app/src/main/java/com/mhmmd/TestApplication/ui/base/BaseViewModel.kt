package com.mhmmd.TestApplication.ui.base

import androidx.lifecycle.ViewModel
import com.mhmmd.TestApplication.utils.rx.SchedulerProvider

abstract class BaseViewModel(val mSchedulerProvider: SchedulerProvider): ViewModel() {


    open fun getSchedulerProvider(): SchedulerProvider? {
        return mSchedulerProvider
    }
}