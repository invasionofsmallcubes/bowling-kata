package com.invasionofsmallcubes.bowling

object FrameFactory {

    private val scoreByDelivery = mapOf('1' to 1, '2' to 2, '3' to 3,
            '4' to 4, '5' to 5, '6' to 6, '7' to 7, '8' to 8,
            '9' to 9, 'X' to 10, '/' to 10, '-' to 0
    )

    private const val NEXT_FRAME = 1
    private const val NEXT_TWO_FRAMES = 2
    private const val NEXT_DELIVERY = 1
    private const val NEXT_TWO_DELIVERIES = 1

    fun createFrame(index: Int, frames: List<String>, currentFrames: String, sequenceOfRolls: String): Frame {
        return when {
            currentFrames.contains("/") -> {
                val nextSpareDelivery = calculateSpareDelivery(currentFrames, index, frames, sequenceOfRolls)
                Spare(scoreByDelivery[nextSpareDelivery]!!)
            }
            currentFrames.contains("X") -> {
                val (nextFirstStrikeDelivery, nextStrikeDelivery) = calculateStrikesDelivery(currentFrames, index, frames, sequenceOfRolls)
                Strike(listOf(scoreByDelivery[nextFirstStrikeDelivery]!!, scoreByDelivery[nextStrikeDelivery]!!))
            }
            else -> Normal(currentFrames.map { f -> scoreByDelivery[f]!! })
        }
    }

    private fun calculateStrikesDelivery(currentFrame: String, index: Int, frames: List<String>, sequenceOfRolls: String): Pair<Char, Char> {
        return if (isLastFrame(index, frames, currentFrame)) Pair(currentFrame[NEXT_DELIVERY], currentFrame[NEXT_TWO_DELIVERIES]) else {
            val position = if (frames[index + NEXT_FRAME].length == 2) ((index + NEXT_FRAME) * 2) + 1 else ((index + NEXT_TWO_FRAMES) * 2)
            Pair(sequenceOfRolls[(index + 1) * 2], sequenceOfRolls[position])
        }
    }

    private fun calculateSpareDelivery(currentFrame: String, index: Int, frames: List<String>, sequenceOfRolls: String): Char {
        return if (isLastFrame(index, frames, currentFrame)) currentFrame[NEXT_TWO_DELIVERIES] else sequenceOfRolls[(index + NEXT_FRAME) * 3]
    }

    private fun isLastFrame(index: Int, frames: List<String>, it: String) =
            (index == frames.size - 1) && (it.length == 3)
}