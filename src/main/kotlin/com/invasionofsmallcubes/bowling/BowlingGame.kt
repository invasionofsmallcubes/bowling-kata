package com.invasionofsmallcubes.bowling

class BowlingGame {

    fun evaluateScore(sequenceOfRolls: String): Int {

        val frames = sequenceOfRolls
                .split(" ")

        return (frames + "")
                .zipWithNext()
                .map { (curr, next) -> FrameFactory.createFrame(curr, next) }
                .fold(0, { acc, frame -> acc + frame.score() })

    }

}