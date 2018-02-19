package com.invasionofsmallcubes.bowling

class Strike(private val shots: String) : Frame {
    override fun score(): Int {
        return shots
                .fold(10,
                        {acc, c -> acc + c.toString().toInt()} )
    }
}