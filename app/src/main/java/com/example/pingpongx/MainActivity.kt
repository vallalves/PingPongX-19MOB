package com.example.pingpongx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this)
            .get(mainViewModel::class.java)

        setUpPlayers()
        registerObserver()

        btPlayerOneScore.setOnClickListener {
            mainViewModel.golPlayer1()
        }

        btPlayerTwoScore.setOnClickListener {
            mainViewModel.golPlayer2()
        }

        btFinishMatch.setOnClickListener {
            finish()
        }
    }

    private fun registerObserver() {
        mainViewModel.playerOneScore.observe(this, Observer {
            tvPlayerOneScore.text = it.toString()
        })

        mainViewModel.playerTwoScore.observe(this, Observer {
                tvPlayerTwoName.text = it.toString()
        })
    }

    private fun setUpPlayers() {
        tvPlayerOneName.text = intent.getStringExtra(Constants.KEY_EXTRA_PLAYER_1)
        tvPlayerTwoName.text = intent.getStringExtra(Constants.KEY_EXTRA_PLAYER_2)
    }



}
