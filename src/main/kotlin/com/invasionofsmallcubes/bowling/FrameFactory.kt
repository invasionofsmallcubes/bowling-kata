package com.invasionofsmallcubes.bowling

import com.invasionofsmallcubes.bowling.FrameObject.Frame

object FrameFactory {

    private const val LAST_FRAME = ""
    private const val SPARE = "/"
    private const val STRIKE = "X"

    fun createFrame(currentFrame: String, nextFrame: String): Frame {

        val next = if (nextFrame == LAST_FRAME) currentFrame else nextFrame

        return when {
            currentFrame.contains(SPARE) -> {
                Spare(next)
            }
            currentFrame.contains(STRIKE) -> {
                Strike(next)
            }
            else -> Normal(currentFrame)
        }

    }
}