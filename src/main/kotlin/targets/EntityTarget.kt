package targets

import models.GameEntity
import models.Player

sealed class EntityTarget(val player: Player, val entity: GameEntity)
