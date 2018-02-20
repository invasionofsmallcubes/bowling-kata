package com.invasionofsmallcubes.bowling

import com.invasionofsmallcubes.bowling.FrameObject.Frame
import com.invasionofsmallcubes.bowling.FrameObject.scoreByDelivery

class Spare(nextShot: String) : Frame {

    private val nextShot =  scoreByDelivery[nextShot[0]]!!

    override fun score(): Int = 10 + nextShot

}