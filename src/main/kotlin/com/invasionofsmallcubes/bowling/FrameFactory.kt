package com.invasionofsmallcubes.bowling

object FrameFactory {

    private val scoreByDelivery = mapOf('1' to 1, '2' to 2, '3' to 3,
            '4' to 4, '5' to 5, '6' to 6, '7' to 7, '8' to 8,
            '9' to 9, 'X' to 10, '/' to 10, '-' to 0
    )

    private const val LAST_FRAME = ""

    fun createFrame(currentFrame: String, nextFrame: String) : Frame.Frame {

        val next = if(nextFrame == LAST_FRAME) currentFrame else nextFrame

        return when {
            currentFrame.contains("/") -> {
                Spare(next)
            }
            currentFrame.contains("X") -> {
                Strike(next)
            }
            else -> Normal(currentFrame.map { f -> scoreByDelivery[f]!! })
        }

    }
}