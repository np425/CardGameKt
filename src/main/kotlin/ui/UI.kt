package ui

import com.github.ajalt.mordant.terminal.Terminal
import models.Game

object UI {
    private var terminal = Terminal()

    fun printProgress(message: String) {
        terminal.success("> $message")
    }

    fun printInfo(message: String) {
        terminal.info(message)
    }

    fun printWarning(message: String) {
        terminal.warning("{!} $message")
    }

    fun printDanger(message: String) {
        terminal.danger(message)
    }

    fun printPlayersInfo(game: Game) {
        with (game) {
            printInfo("${playerA.name}[H:${playerA.health}; M:${playerA.mana}], ${playerB.name}[H:${playerB.health}; M:${playerB.mana}]")
        }
    }
}