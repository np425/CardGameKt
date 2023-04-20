package context

import models.Card
import models.Game
import models.Player

open class CardContext(game: Game, me: Player, enemy: Player, val card: Card) : GameContext(game, me, enemy)