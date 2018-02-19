package com.invasionofsmallcubes.bowling

class Spare(private val nextShot: Int) : Frame {
    override fun score(): Int {
        return 10 + nextShot
    }
}