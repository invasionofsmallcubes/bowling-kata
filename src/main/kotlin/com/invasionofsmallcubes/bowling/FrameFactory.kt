package com.invasionofsmallcubes.bowling

object FrameFactory {

    private const val LAST_FRAME = ""

    fun createFrame(currentFrame: String, nextFrame: String) : FrameObject.Frame {

        val next = if(nextFrame == LAST_FRAME) currentFrame else nextFrame

        return when {
            currentFrame.contains("/") -> {
                Spare(next)
            }
            currentFrame.contains("X") -> {
                Strike(next)
            }
            else -> Normal(currentFrame)
        }

    }
}