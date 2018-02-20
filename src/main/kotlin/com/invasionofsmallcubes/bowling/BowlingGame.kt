package com.invasionofsmallcubes.bowling

class BowlingGame {

    private val EMPTY_VALUE = ""
    private val BY_SPACE = " "

    fun evaluateScore(sequenceOfRolls: String): Int {

        val frames = sequenceOfRolls
                .split(BY_SPACE)

        return (frames + EMPTY_VALUE)
                .zipWithNext()
                .map { (curr, next) -> FrameFactory.createFrame(curr, next) }
                .fold(0, { acc, frame -> acc + frame.score() })

    }

}