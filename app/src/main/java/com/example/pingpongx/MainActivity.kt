package com.example.pingpongx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    // Inicializar só quando for usada.
    lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this)
            .get(mainViewModel::class.java)

        setUpPlayers()

        tvPlayerOneScore.text = mainViewModel.playerOneScore.toString()
        
        btPlayerOneScore.setOnClickListener {
            tvPlayerOneScore.text = mainViewModel.playerOneScore.toString()
        }


    }

    private fun setUpPlayers() {
        tvPlayerOneName.text = intent.getStringExtra(Constants.KEY_EXTRA_PLAYER_1)
        tvPlayerTwoName.text = intent.getStringExtra(Constants.KEY_EXTRA_PLAYER_2)
    }
}
