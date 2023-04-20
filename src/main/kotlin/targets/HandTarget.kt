package targets

import models.Card
import models.Player

class HandTarget(player: Player, val index: Int, val card: Card) : EntityTarget(player, card)