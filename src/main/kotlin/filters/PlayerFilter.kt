package filters

import models.Card

class PlayerFilter(
    val hand: Iterable<IndexedValue<Card>> = arrayListOf(),
    val deck: Iterable<IndexedValue<Card>> = arrayListOf(),
    val board: Iterable<IndexedValue<Card>> = arrayListOf(),
    val canAttackHero: Boolean = false
)