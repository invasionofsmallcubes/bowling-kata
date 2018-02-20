package com.invasionofsmallcubes.bowling.frame

import com.invasionofsmallcubes.bowling.frame.FrameObject.Frame
import com.invasionofsmallcubes.bowling.frame.FrameObject.scoreByDelivery

class Spare(nextShot: String) : Frame {

    private val nextShot =  scoreByDelivery[nextShot[0]]!!

    override fun score(): Int = 10 + nextShot

}