package com.mhmmd.TestApplication.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mhmmd.TestApplication.data.model.db.GameEntity
import com.mhmmd.TestApplication.data.repository.MainRepository
import com.mhmmd.TestApplication.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val mainRepository: MainRepository): ViewModel() {

    private val games = MutableLiveData<Resource<List<GameEntity>>>()
    private val compositeDisposable = CompositeDisposable()

    init {
//        saveGamesInDb()
        loadGamesList();
    }

    private fun saveGamesInDb(){
        val gameItem = GameEntity(player_one = "Barcelona", player_two = "RealMadrid")
        compositeDisposable.add(
            mainRepository.saveGame(gameItem)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ ->
            print("Data Saved in local DB")
        }, {throwable ->
            print("Exception occured")
        })
        )
    }

    fun loadGamesList(){
        compositeDisposable.add(
            mainRepository.loadGamesList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({gameList ->
                    games.postValue(Resource.success(gameList))
                },{throwable ->
                    print("Errrroroooorr")
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getGames(): LiveData<Resource<List<GameEntity>>> {
        return games
    }



}