package com.invasionofsmallcubes.bowling

class BowlingGame {
    fun evaluateScore(sequenceOfRolls: String): Int {

        var score = 0

        sequenceOfRolls
                .split(" ")
                .forEachIndexed { index, frameSequence ->
                    score += when {
                        frameSequence.contains("/") -> Spare(sequenceOfRolls[index + 1 * 3].toString().toInt()).score()
                        frameSequence.contains("X") -> Strike(sequenceOfRolls[index + 1 * 2].toString() + sequenceOfRolls[index + 1 * 2 + 1].toString()).score()
                        else -> Normal(frameSequence).score()
                    }
                }

        return score
    }
}