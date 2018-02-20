package com.invasionofsmallcubes.bowling

class Strike(shots: String) : FrameObject.Frame {

    private val STRIKE = 'X'

    private val shots = listOf(FrameObject.scoreByDelivery[shots[0]]!!,
            FrameObject.scoreByDelivery.getOrDefault(shots.getOrElse(1, { STRIKE }), 0))

    override fun score(): Int = shots.fold(10, { acc, c -> acc + c })

}