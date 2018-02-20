package com.invasionofsmallcubes.bowling

class Normal(private val shots: List<Int>) : Frame.Frame {
    override fun score(): Int = shots.fold(0, { acc, score -> acc + score })
}