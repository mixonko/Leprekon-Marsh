package com.lep20.marsh.gam.presenter

import com.lep20.marsh.gam.view.MenuActivity

class MenuPresenter(private val view : MenuActivity) {
    fun onPlayClick() {
        view.startGameActivity()
    }

    fun onWebViewClick() {
        view.startWebViewActivity()
    }
}
