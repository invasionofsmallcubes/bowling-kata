package com.invasionofsmallcubes.bowling.frame

import com.invasionofsmallcubes.bowling.frame.FrameObject.Frame
import com.invasionofsmallcubes.bowling.frame.FrameObject.scoreByDelivery

class Strike(shots: String) : Frame {

    private val STRIKE = 'X'

    private val shots = listOf(firstShot(shots),
            secondShot(shots))

    override fun score(): Int = shots.fold(10, { acc, c -> acc + c })

    private fun secondShot(shots: String) = scoreByDelivery.getOrDefault(shots.getOrElse(1, { STRIKE }), 0)

    private fun firstShot(shots: String) = scoreByDelivery[shots[0]]!!

}