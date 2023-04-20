package targets

import models.Card
import models.Player

class BoardTarget(player: Player, val index: Int, val card: Card) : EntityTarget(player, card)