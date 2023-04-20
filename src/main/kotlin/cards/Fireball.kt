package cards

import context.AttackContext
import models.Spell
import models.SpellClass
import context.GameContext
import context.CardContext
import filters.AttackFilter
import filters.PlayerFilter
import models.HasDamage
import ui.AttackSelectionView
import ui.UI

class Fireball(
    override var damage: Int = 6,
    name: String = "Fireball",
    desc: String = "deal $damage damage",
    mana: Int = 4,
    spellClass: SpellClass = SpellClass.Fire
) : Spell(name, desc, mana, spellClass), HasDamage {

    override fun onActivate(context: GameContext) {
        UI.printProgress("Throwing fireball with ${this.damage} damage!")

        val attackFilter = AttackFilter(
            CardContext(context.game, context.me, context.enemy, this@Fireball),
            meFilter = PlayerFilter(canAttackHero = true, board = context.me.board.withIndex()),
            enemyFilter = PlayerFilter(canAttackHero = true, board = context.me.board.withIndex())
        )

        val target = AttackSelectionView(attackFilter).handleSelection()

        AttackContext(context.game, context.me, context.enemy, this, target).inflictDamage(damage)
    }
}