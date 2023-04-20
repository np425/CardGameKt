package parsers

import context.GameContext
import models.Player
import targets.*

class AttackSelectionParser(private val context: GameContext) {
    fun parse(tokens: Iterator<String>): EntityTarget? {
        val player = parsePlayer(tokens) ?: return null

        return parsePlace(tokens, player)
    }

    private fun parsePlayer(tokens: Iterator<String>): Player? {
        if (!tokens.hasNext()) {
            return null
        }

        return when (tokens.next().lowercase()) {
            "my" -> context.me
            "enemy" -> context.enemy
            else -> null
        }
    }

    private fun parsePlace(tokens: Iterator<String>, player: Player): EntityTarget? {
        if (!tokens.hasNext()) {
            return null
        }

        val place = tokens.next().lowercase()
        if (place == "hero") {
            return PlayerTarget(player)
        }

        val index = parseIndex(tokens) ?: return null
        return when (place) {
            "hand" -> HandTarget(player, index, context.me.hand.getOrNull(index) ?: return null)
            "deck" -> DeckTarget(player, index, context.me.deck.getOrNull(index) ?: return null)
            "board" -> BoardTarget(player, index, context.me.board.getOrNull(index) ?: return null)
            else -> null
        }
    }

    private fun parseIndex(tokens: Iterator<String>): Int? {
        if (!tokens.hasNext()) {
            return null
        }

        return tokens.next().toIntOrNull()
    }
}