package com.invasionofsmallcubes.bowling.frame

import com.invasionofsmallcubes.bowling.frame.FrameObject.Frame
import com.invasionofsmallcubes.bowling.frame.FrameObject.scoreByDelivery

class Normal(private val shots: String) : Frame {
    override fun score(): Int = shots.fold(0, { acc, score -> acc + scoreByDelivery[score]!! })
}