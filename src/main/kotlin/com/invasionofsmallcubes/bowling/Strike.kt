package com.invasionofsmallcubes.bowling

import com.invasionofsmallcubes.bowling.FrameObject.Frame
import com.invasionofsmallcubes.bowling.FrameObject.scoreByDelivery

class Strike(shots: String) : Frame {

    private val STRIKE = 'X'

    private val shots = listOf(scoreByDelivery[shots[0]]!!,
            scoreByDelivery.getOrDefault(shots.getOrElse(1, { STRIKE }), 0))

    override fun score(): Int = shots.fold(10, { acc, c -> acc + c })

}