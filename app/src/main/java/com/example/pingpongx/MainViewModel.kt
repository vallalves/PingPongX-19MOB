package com.example.pingpongx
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    var playerOneScore = MutableLiveData<Int>()
    var playerTwoScore = MutableLiveData<Int>()


    init {
        revenge()
    }

    fun golPlayer1(){
        playerOneScore.value = playerOneScore.value?.plus(1)
    }

    fun golPlayer2() {
        playerOneScore.value = playerTwoScore.value?.plus(1)
    }

    fun revenge(){
        playerOneScore.value = 0
        playerTwoScore.value = 0
    }

}