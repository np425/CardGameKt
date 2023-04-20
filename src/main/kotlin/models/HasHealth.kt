package models

interface HasHealth {
    var health: Int
    fun inflictDamage(damage: Int) {
        this.health -= damage
    }
}