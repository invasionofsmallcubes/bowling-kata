package com.invasionofsmallcubes.bowling

class Normal(private val shots: String) : FrameObject.Frame {
    override fun score(): Int = shots.fold(0, { acc, score -> acc + FrameObject.scoreByDelivery[score]!! })
}