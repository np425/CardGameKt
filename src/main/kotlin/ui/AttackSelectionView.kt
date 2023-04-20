package ui

import filters.AttackFilter
import filters.PlayerFilter
import models.Card
import parsers.AttackSelectionParser
import targets.*

class AttackSelectionView(
    private val filter: AttackFilter,
    private val attackSelectionParser: AttackSelectionParser = AttackSelectionParser(filter.context)
) {
    private fun displayOptions() {
        displayPlayerAttackOptions(filter.meFilter, "his")
        displayPlayerAttackOptions(filter.enemyFilter, filter.context.enemy.name + "'s")
    }

    private fun displayPlayerAttackOptions(playerAttackContext: PlayerFilter, referenceName: String) {
        UI.printInfo("${filter.context.me.name} can attack $referenceName: ")

        displayAttackPlace("board", playerAttackContext.board)
        displayAttackPlace("hand", playerAttackContext.hand)
        displayAttackPlace("deck", playerAttackContext.deck)

        if (playerAttackContext.canAttackHero) {
            UI.printInfo("\t hero")
        }
    }

    private fun displayAttackPlace(place: String, cards: Iterable<IndexedValue<Card>>) {
        if (cards.any()) {
            val joinedCards = cards.joinToString { (index, card) -> "${index + 1}${card.name}" }
            UI.printInfo("\t $place: $joinedCards")
        }
    }

    fun handleSelection(): EntityTarget {
        UI.printWarning("${filter.context.card.name} requires for ${filter.context.me.name} to select it's target!")
        displayOptions()

        var selection: EntityTarget?

        do {
            selection = promptSelection()
        } while (selection == null || !validateSelection(selection))

        return selection
    }

    private fun validateSelection(selection: EntityTarget): Boolean {
        val playerFilter = when (selection.player) {
            filter.context.me -> filter.meFilter
            filter.context.enemy -> filter.enemyFilter
            else -> return false
        }

        return when (selection) {
            is BoardTarget -> playerFilter.board.any { (index, _) -> index == selection.index }
            is DeckTarget -> playerFilter.deck.any { (index, _) -> index == selection.index }
            is HandTarget -> playerFilter.hand.any { (index, _) -> index == selection.index }
            is PlayerTarget -> playerFilter.canAttackHero
        }
    }

    private fun promptSelection(): EntityTarget? {
        UI.printWarning("Select what ${filter.context.card.name} should attack: ")
        val tokensIterator = readln().splitToSequence(' ').iterator()

        return attackSelectionParser.parse(tokensIterator)
    }

}