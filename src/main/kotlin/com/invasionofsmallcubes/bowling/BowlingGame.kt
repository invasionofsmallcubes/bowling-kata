package com.invasionofsmallcubes.bowling

class BowlingGame {

    fun evaluateScore(sequenceOfRolls: String): Int {

        val frames = sequenceOfRolls
                .split(" ")

        return frames
                .mapIndexed { index, it -> FrameFactory.createFrame(index, frames, it, sequenceOfRolls) }
                .fold(0, { acc, frame -> acc + frame.score() })

    }

}