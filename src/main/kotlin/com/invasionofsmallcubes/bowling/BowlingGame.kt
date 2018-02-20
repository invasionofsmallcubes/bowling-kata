package com.invasionofsmallcubes.bowling

class BowlingGame {

    private val scoreByDelivery = mapOf(
            '1' to 1,
            '2' to 2,
            '3' to 3,
            '4' to 4,
            '5' to 5,
            '6' to 6,
            '7' to 7,
            '8' to 8,
            '9' to 9,
            'X' to 10,
            '/' to 10,
            '-' to 0

    )

    fun evaluateScore(sequenceOfRolls: String): Int {
        val framesPairs = sequenceOfRolls
                .split(" ")
        return framesPairs
                .mapIndexed { index, it -> getFrame(index, framesPairs, it, sequenceOfRolls) }
                .fold(0, { acc, frs -> acc + frs.score() })
    }

    private fun getFrame(index: Int, frames: List<String>, it: String, sequenceOfRolls: String): Frame {

        val nextSpareDelivery = if (it.contains("/")) {
            if (isLastFrame(index, frames, it)) it[2] else sequenceOfRolls[(index + 1) * 3]
        } else 'a'

        val (nextFirstStrike, nextSecondStirke) = if (it.contains("X")) {
            if (isLastFrame(index, frames, it)) Pair(it[1], it[2]) else {
                val position = if (frames[index + 1].length == 2) ((index + 1) * 2) + 1 else ((index + 2) * 2)
                Pair(sequenceOfRolls[(index + 1) * 2], sequenceOfRolls[position])
            }
        } else Pair('a', 'a')

        return if (isLastFrame(index, frames, it)) {
            when {
                it.contains("/") -> Spare(scoreByDelivery[nextSpareDelivery]!!)
                else -> Strike(listOf(scoreByDelivery[it[1]]!!,
                        scoreByDelivery[it[2]]!!))
            }
        } else {
            when {
                it.contains("/") -> Spare(scoreByDelivery[nextSpareDelivery]!!)
                it.contains("X") -> {
                    Strike(listOf(scoreByDelivery[nextFirstStrike]!!,
                            scoreByDelivery[nextSecondStirke]!!))
                }
                else -> Normal(it)
            }
        }
    }

    private fun isLastFrame(index: Int, frames: List<String>, it: String) =
            (index == frames.size - 1) && (it.length == 3)
}