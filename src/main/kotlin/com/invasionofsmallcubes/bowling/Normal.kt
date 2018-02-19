package com.invasionofsmallcubes.bowling

class Normal(private val shots: String) : Frame {
    override fun score(): Int {
        var score = 0
        shots
                .filter { c -> c != '-' }
                .forEach { c -> score += c.toString().toInt() }
        return score
    }
}