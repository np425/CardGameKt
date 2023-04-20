package filters

import context.CardContext

class AttackFilter(val context: CardContext, val meFilter: PlayerFilter, val enemyFilter: PlayerFilter)