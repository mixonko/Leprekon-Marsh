package com.lep20.marsh.gam.model

class WinnerCheck {
    private var winner: Int = 0

    fun check(gameArray: Array<Array<Int>>): Int{

        for (i in 0..2){
            if (gameArray[i][0] == gameArray[i][1] && gameArray[i][0] == gameArray[i][2] && gameArray[i][0] != 0){
                winner = gameArray[i][0]
                return winner

            }

        }

        for (i in 0..2){
            if (gameArray[0][i] == gameArray[1][i] && gameArray[0][i] == gameArray[2][i] && gameArray[0][i] != 0){
                winner = gameArray[0][i]
                return winner
            }

        }

        if (gameArray[0][0] == gameArray[1][1] && gameArray[0][0] == gameArray[2][2] && gameArray[0][0] != 0){
            winner = gameArray[1][1]
            return winner
        }

        if (gameArray[2][0] == gameArray[1][1] && gameArray[2][0] == gameArray[0][2] && gameArray[2][0] != 0){
            winner = gameArray[1][1]
            return winner
        }

        return winner
    }

}
