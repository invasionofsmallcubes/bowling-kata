package com.invasionofsmallcubes.bowling

class BowlingGame {

    private val scoreByDelivery = mapOf(
            '1' to "1",
            '2' to "2",
            '3' to "3",
            '4' to "4",
            '5' to "5",
            '6' to "6",
            '7' to "7",
            '8' to "8",
            '9' to "9",
            'X' to "10",
            '/' to "10",
            '-' to "0"

    )

    fun evaluateScore(sequenceOfRolls: String): Int {

        var score = 0

        val frames = sequenceOfRolls
                .split(" ")

        frames
                .forEachIndexed { index, frameSequence ->
                    if( index == frames.size-1 && frameSequence.length == 3 ) {

                    } else {
                        score += when {
                            frameSequence.contains("/") -> Spare(scoreByDelivery[sequenceOfRolls[index + 1 * 3]]!!.toInt()).score()
                            frameSequence.contains("X") -> Strike(scoreByDelivery[sequenceOfRolls[index + 1 * 2]] + scoreByDelivery[sequenceOfRolls[index + 1 * 2 + 1]]).score()
                            else -> Normal(frameSequence).score()
                        }
                    }
                }

        return score
    }
}