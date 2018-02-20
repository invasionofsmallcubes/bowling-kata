package com.invasionofsmallcubes.bowling

class Spare(private val nextShot: Int) : Frame {
    override fun score(): Int = 10 + nextShot

}