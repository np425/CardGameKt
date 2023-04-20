package targets

import models.Card
import models.Player

class DeckTarget(player: Player, val index: Int, val card: Card) : EntityTarget(player, card)