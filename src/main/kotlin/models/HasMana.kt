package models

interface HasMana {
    var mana: Int
    fun useMana(mana: Int) {
        this.mana -= mana
    }
}