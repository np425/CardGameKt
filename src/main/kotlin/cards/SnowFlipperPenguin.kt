package cards

import models.Minion
import models.MinionClass

class SnowFlipperPenguin(
    damage: Int = 1,
    health: Int = 1,
    minionClass: MinionClass = MinionClass.Beast,
    name: String = "Snow Flipper Penguin",
    desc: String = "",
    mana: Int = 0
) : Minion(damage, health, minionClass, name, desc, mana)