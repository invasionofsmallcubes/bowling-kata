package com.invasionofsmallcubes.bowling

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class BowlingGameTest {

    private val bowlingGame = BowlingGame()

    @Test
    fun scoreOfMissIsZero() {
        evaluateScore("-", 0)
    }

    @Test
    fun missAndNumber() {
        evaluateScore("-9", 9)
        evaluateScore("-8", 8)
    }

    @Test
    fun twoFrames() {
        evaluateScore("-- --", 0)
        evaluateScore("-9 --", 9)
    }

    @Test
    fun aSpare() {
        evaluateScore("5/ 5", 20)
        evaluateScore("5/ 6", 22)
    }

    @Test
    fun aStrike() {
        evaluateScore("X 51", 22)
        evaluateScore("X 61", 24)
    }

    @Test
    fun lastFrame() {
        evaluateScore("51 XXX", 36)
    }

    private fun evaluateScore(sequenceOfRolls: String, score: Int) {
        assertThat(bowlingGame.evaluateScore(sequenceOfRolls), `is`(score))
    }
}