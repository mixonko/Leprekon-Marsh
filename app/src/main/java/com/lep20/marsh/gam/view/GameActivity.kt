package com.lep20.marsh.gam.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.lep20.marsh.gam.R
import com.lep20.marsh.gam.contract.GameContract
import com.lep20.marsh.gam.presenter.GamePresenter

class GameActivity : AppCompatActivity(), GameContract, View.OnClickListener {


    private lateinit var presenter: GamePresenter

    private lateinit var imageView11: ImageView
    private lateinit var imageView12: ImageView
    private lateinit var imageView13: ImageView
    private lateinit var imageView21: ImageView
    private lateinit var imageView22: ImageView
    private lateinit var imageView23: ImageView
    private lateinit var imageView31: ImageView
    private lateinit var imageView32: ImageView
    private lateinit var imageView33: ImageView
    private lateinit var youWin: LinearLayout
    private lateinit var resetGame: ImageView
    private lateinit var winner: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_game)

        presenter = GamePresenter(this)

        init()
        setTag()
        setOnClickListener()

    }

    private fun setTag() {
        imageView11.tag = 11
        imageView12.tag = 12
        imageView13.tag = 13
        imageView21.tag = 21
        imageView22.tag = 22
        imageView23.tag = 23
        imageView31.tag = 31
        imageView32.tag = 32
        imageView33.tag = 33
    }

    private fun init() {
        imageView11 = findViewById(R.id.imageView11)
        imageView12 = findViewById(R.id.imageView12)
        imageView13 = findViewById(R.id.imageView13)
        imageView21 = findViewById(R.id.imageView21)
        imageView22 = findViewById(R.id.imageView22)
        imageView23 = findViewById(R.id.imageView23)
        imageView31 = findViewById(R.id.imageView31)
        imageView32 = findViewById(R.id.imageView32)
        imageView33 = findViewById(R.id.imageView33)
        youWin = findViewById(R.id.you_win)
        resetGame = findViewById(R.id.resetGameButton)
        winner = findViewById(R.id.winner)
    }

    private fun setOnClickListener() {
        imageView11.setOnClickListener(this)
        imageView12.setOnClickListener(this)
        imageView13.setOnClickListener(this)
        imageView21.setOnClickListener(this)
        imageView22.setOnClickListener(this)
        imageView23.setOnClickListener(this)
        imageView31.setOnClickListener(this)
        imageView32.setOnClickListener(this)
        imageView33.setOnClickListener(this)
        resetGame.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.imageView11 -> presenter.onImageClick(v as ImageView, v.tag.toString().toInt())
            R.id.imageView12 -> presenter.onImageClick(v as ImageView, v.tag.toString().toInt())
            R.id.imageView13 -> presenter.onImageClick(v as ImageView, v.tag.toString().toInt())
            R.id.imageView21 -> presenter.onImageClick(v as ImageView, v.tag.toString().toInt())
            R.id.imageView22 -> presenter.onImageClick(v as ImageView, v.tag.toString().toInt())
            R.id.imageView23 -> presenter.onImageClick(v as ImageView, v.tag.toString().toInt())
            R.id.imageView31 -> presenter.onImageClick(v as ImageView, v.tag.toString().toInt())
            R.id.imageView32 -> presenter.onImageClick(v as ImageView, v.tag.toString().toInt())
            R.id.imageView33 -> presenter.onImageClick(v as ImageView, v.tag.toString().toInt())
            R.id.resetGameButton -> presenter.resetGameClicked()
        }
    }

    override fun recreateActivity() {
        startActivity(Intent(this, GameActivity::class.java))
        finish()
    }

    override fun setImageSecondPlayer(imageView: ImageView) {
        imageView.setImageResource(R.drawable.second_player)
    }

    override fun setImageFirstPlayer(imageView: ImageView) {
        imageView.setImageResource(R.drawable.first_player)
    }

    override fun setDisabled(imageView: ImageView) {
        imageView.isEnabled = false
    }

    override fun showWinnerFirstPlayer() {
        Handler().postDelayed({
            winner.setImageResource(R.drawable.first_player)
        }, 500)
    }

    override fun showWinnerSecondPlayer() {
        Handler().postDelayed({
            winner.setImageResource(R.drawable.second_player)
        }, 500)
    }

    override fun showYouWin() {
        Handler().postDelayed({
            youWin.visibility = View.VISIBLE
            imageView11.visibility = View.INVISIBLE
            imageView12.visibility = View.INVISIBLE
            imageView13.visibility = View.INVISIBLE
            imageView21.visibility = View.INVISIBLE
            imageView22.visibility = View.INVISIBLE
            imageView23.visibility = View.INVISIBLE
        }, 500)
    }

    override fun setAllDisabled() {
            imageView11.isEnabled = false
            imageView12.isEnabled = false
            imageView13.isEnabled = false
            imageView21.isEnabled = false
            imageView22.isEnabled = false
            imageView23.isEnabled = false
            imageView31.isEnabled = false
            imageView32.isEnabled = false
            imageView33.isEnabled = false

    }

}
