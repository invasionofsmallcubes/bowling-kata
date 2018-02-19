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
        return if (isLastFrame(index, frames, it)) {
            when {
                it.contains("/") -> Spare(scoreByDelivery[it[2]]!!)
                else -> Strike(listOf(scoreByDelivery[it[1]]!!,
                        scoreByDelivery[it[2]]!!))
            }
        } else {
            when {
                it.contains("/") -> Spare(scoreByDelivery[sequenceOfRolls[(index + 1) * 3]]!!)
                it.contains("X") -> {
                    val position = if (frames[index + 1].length == 2) ((index + 1) * 2) + 1 else ((index + 2) * 2)
                    Strike(listOf(scoreByDelivery[sequenceOfRolls[(index + 1) * 2]]!!,
                            scoreByDelivery[sequenceOfRolls[position]]!!))
                }
                else -> Normal(it)
            }
        }
    }

    private fun isLastFrame(index: Int, frames: List<String>, it: String) =
            index == frames.size - 1 && it.length == 3
}