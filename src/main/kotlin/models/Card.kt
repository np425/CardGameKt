package models

import context.GameContext

abstract class Card(override var name: String, private var desc: String, override var mana: Int) : GameEntity(),
    HasMana, HasName {
    abstract fun onActivate(context: GameContext)
}