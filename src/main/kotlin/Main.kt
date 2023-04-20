import ui.UI
import cards.Fireball
import cards.SnowFlipperPenguin
import context.GameContext
import models.Game
import models.Player

fun main() {
    val playerA = Player("Mario", health = 30, mana = 10, hand = arrayListOf(Fireball(), SnowFlipperPenguin()))
    val playerB = Player("Luigi", health = 15, mana = 5, hand = arrayListOf(Fireball()))
    val game = Game(playerA, playerB)

    UI.printPlayersInfo(game)

    val context = GameContext(game, me = playerA, enemy = playerB)
    context.playCardFromHand(1)

    UI.printPlayersInfo(game)

//    terminal.info("${playerA.name} health: ${playerA.getHealth()}, ${playerB.name} health: ${playerB.getHealth()}")
//
//    terminal.success("${playerB.name} plays cards!")
//    game.playCards(game.playerB)
//
//    terminal.info("_ ${playerA.name} health: ${playerA.getHealth()}, ${playerB.name} health: ${playerB.getHealth()}")

//    println("Playing random player cards!")
//    game.playCards(models.Player(30, arrayListOf(), arrayListOf(), arrayListOf()))
//
//    println("PlayerA health: ${playerA.health}, PlayerB health: ${playerB.health}")
}
