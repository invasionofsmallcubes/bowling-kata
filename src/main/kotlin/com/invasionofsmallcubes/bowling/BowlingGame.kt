package com.invasionofsmallcubes.bowling

import com.invasionofsmallcubes.bowling.frame.FrameFactory.createFrame
import com.invasionofsmallcubes.bowling.frame.FrameObject

class BowlingGame {

    private val EMPTY_VALUE = ""
    private val BY_SPACE = " "
    private val SCORE = 0

    fun evaluateScore(sequenceOfRolls: String): Int {
        val splitFrames = splitFrames(sequenceOfRolls)
        val listOfFrames = createListOfFrames(splitFrames)
        return countScore(listOfFrames)
    }

    private fun countScore(listOfFrames: List<FrameObject.Frame>) =
            listOfFrames
                    .fold(SCORE, { acc, frame -> acc + frame.score() })

    private fun createListOfFrames(frames: List<String>): List<FrameObject.Frame> {
        return (frames + EMPTY_VALUE)
                .zipWithNext()
                .map { (curr, next) -> createFrame(curr, next) }
    }

    private fun splitFrames(sequenceOfRolls: String) = sequenceOfRolls
            .split(BY_SPACE)
}