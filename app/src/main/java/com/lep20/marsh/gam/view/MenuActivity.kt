package com.lep20.marsh.gam.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import com.lep20.marsh.gam.R
import com.lep20.marsh.gam.contract.MenuContract
import com.lep20.marsh.gam.presenter.MenuPresenter

class MenuActivity : AppCompatActivity(), MenuContract {

    private lateinit var presenter: MenuPresenter
    private lateinit var play: ImageView
    private lateinit var webView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_menu)

        presenter = MenuPresenter(this)

        init()
        setOnClickListener()
    }

    private fun setOnClickListener() {
        play.setOnClickListener {
            presenter.onPlayClick()
        }
        webView.setOnClickListener {
            presenter.onWebViewClick()
        }
    }

    fun init(){
        play = findViewById(R.id.playButton)
        webView = findViewById(R.id.web_view_button)
    }

    override fun startGameActivity() {
        startActivity(Intent(this, GameActivity::class.java))
    }

    override fun startWebViewActivity() {
        startActivity(Intent(this, WebViewActivity::class.java))
    }

}

