package com.invasionofsmallcubes.bowling

class Strike(shots: String) : Frame.Frame {

    private val STRIKE = 'X'

    private val shots = listOf(Frame.scoreByDelivery[shots[0]]!!,
            Frame.scoreByDelivery.getOrDefault(shots.getOrElse(1, { STRIKE }), 0))

    override fun score(): Int = shots.fold(10, { acc, c -> acc + c })

}