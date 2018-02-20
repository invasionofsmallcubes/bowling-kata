package com.invasionofsmallcubes.bowling

import com.invasionofsmallcubes.bowling.FrameObject.Frame
import com.invasionofsmallcubes.bowling.FrameObject.scoreByDelivery

class Normal(private val shots: String) : Frame {
    override fun score(): Int = shots.fold(0, { acc, score -> acc + scoreByDelivery[score]!! })
}