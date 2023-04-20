package models

class Player(
    override var name: String,
    override var health: Int = 30,
    override var mana: Int = 10,
    var hand: ArrayList<Card> = ArrayList(),
    var deck: ArrayList<Card> = ArrayList(),
    var board: ArrayList<Card> = ArrayList()
) : GameEntity(), HasHealth, HasMana, HasName