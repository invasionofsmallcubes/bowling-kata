package com.invasionofsmallcubes.bowling

class Spare(nextShot: String) : Frame.Frame {

    private val nextShot =  Frame.scoreByDelivery[nextShot[0]]!!

    override fun score(): Int = 10 + nextShot

}