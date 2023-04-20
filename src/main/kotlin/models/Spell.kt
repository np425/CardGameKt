package models

abstract class Spell(name: String, desc: String, mana: Int, spellClass: SpellClass) : Card(name, desc, mana)