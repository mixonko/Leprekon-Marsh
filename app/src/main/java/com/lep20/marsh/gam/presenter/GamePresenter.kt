package com.lep20.marsh.gam.presenter

import android.widget.ImageView
import com.lep20.marsh.gam.model.WinnerCheck
import com.lep20.marsh.gam.view.GameActivity

class GamePresenter(
    private val view: GameActivity,
    private val winnerCheck: WinnerCheck = WinnerCheck()
) {

    private var side: Int = 1
    private var gameArray: Array<Array<Int>> = Array(3) { Array(3) { 0 } }
    private var winner = 0
    private lateinit var imageView: ImageView

    fun onImageClick(imageView: ImageView, tag: Int) {
        this.imageView = imageView
        updateArray(tag)
        if (side == 1) {
            side = 2
            view.setImageFirstPlayer(imageView)
        } else if (side == 2) {
            side = 1
            view.setImageSecondPlayer(imageView)
        }
        view.setDisabled(imageView)
        winnerCheck()


    }

    fun resetGameClicked() {
        view.recreateActivity()
    }

    private fun updateArray(tag: Int) {
        when (tag) {
            11 -> gameArray[0][0] = side
            12 -> gameArray[0][1] = side
            13 -> gameArray[0][2] = side
            21 -> gameArray[1][0] = side
            22 -> gameArray[1][1] = side
            23 -> gameArray[1][2] = side
            31 -> gameArray[2][0] = side
            32 -> gameArray[2][1] = side
            33 -> gameArray[2][2] = side
        }
    }

    private fun winnerCheck() {
        winner = winnerCheck.check(gameArray)
        if (winner != 0) {
            view.setAllDisabled()
            view.hideDesk()
            view.showYouWin()
            if (winner == 1){
                view.showWinnerFirstPlayer()
            }
            if (winner == 2){
                view.showWinnerSecondPlayer()
            }

        }

    }

}
