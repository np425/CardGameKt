package context

import models.Game
import models.Minion
import models.Player
import ui.UI

open class GameContext(val game: Game, val me: Player, val enemy: Player) {
    fun playCardFromHand(cardIndex: Int): Boolean {
        val card = me.hand.removeAt(cardIndex)

        if (me.mana < card.mana) {
            UI.printDanger("${me.name} does not have enough mana (${me.mana}/${card.mana}) to play ${card.name}!")
            return false
        }

        UI.printProgress("${me.name} is playing ${card.name}!")
        card.onActivate(this)
        me.mana -= card.mana

        return true
    }

    fun spawnMinion(minion: Minion) {
        UI.printProgress("${me.name} spawns ${minion.name}!")
        this.me.board.add(minion)
    }
}