package com.lep20.marsh.gam.contract

import android.widget.ImageView

interface GameContract {
    fun recreateActivity()
    fun setImageFirstPlayer(imageView: ImageView)
    fun setImageSecondPlayer(imageView: ImageView)
    fun setDisabled(imageView: ImageView)
    fun showWinnerFirstPlayer()
    fun showWinnerSecondPlayer()
    fun showYouWin()
    fun setAllDisabled()
}
