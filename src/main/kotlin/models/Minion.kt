package models

import context.GameContext

abstract class Minion(override var damage: Int, override var health: Int, var minionClass: MinionClass, name: String, desc: String, mana: Int) :
    Card(name, desc, mana), HasHealth, HasDamage {
    override fun onActivate(context: GameContext) {
        context.spawnMinion(this)
    }
}
