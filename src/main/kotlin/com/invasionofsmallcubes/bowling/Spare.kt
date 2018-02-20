package com.invasionofsmallcubes.bowling

class Spare(nextShot: String) : FrameObject.Frame {

    private val nextShot =  FrameObject.scoreByDelivery[nextShot[0]]!!

    override fun score(): Int = 10 + nextShot

}