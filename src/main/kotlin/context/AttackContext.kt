package context

import models.Card
import models.Game
import models.HasHealth
import models.Player
import targets.EntityTarget
import ui.UI

class AttackContext(game: Game, me: Player, enemy: Player, attacker: Card, private val target: EntityTarget) :
    CardContext(game, me, enemy, attacker) {
    fun inflictDamage(damage: Int): Boolean {
        return when (target.entity) {
            is HasHealth -> {
                val opponentName = if (target.player == me) "themselves" else target.player.name
                UI.printProgress("${me.name} inflicts $damage damage to $opponentName!")
                target.entity.health -= damage
                true
            }

            else -> false
        }
    }
}