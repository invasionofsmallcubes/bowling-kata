package com.invasionofsmallcubes.bowling

object FrameObject {

    val scoreByDelivery = mapOf('1' to 1, '2' to 2, '3' to 3,
            '4' to 4, '5' to 5, '6' to 6, '7' to 7, '8' to 8,
            '9' to 9, 'X' to 10, '/' to 10, '-' to 0
    )

    interface Frame {
        fun score(): Int
    }

}
