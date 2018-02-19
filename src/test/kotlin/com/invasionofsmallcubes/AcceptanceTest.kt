package com.invasionofsmallcubes

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Ignore
import org.junit.Test

@Ignore("everything is failing!!")
class AcceptanceTest {

    private val bowlingGame = BowlingGame()

    @Test
    fun allStrikes() {
        assertEvaluationOnRolls("X X X X X X X X X X X X", 300)
    }

    @Test
    fun ninesAndMisses() {
        assertEvaluationOnRolls("9- 9- 9- 9- 9- 9- 9- 9- 9- 9-", 90)
    }

    @Test
    fun fivesAndSpares() {
        assertEvaluationOnRolls("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5", 150)
    }

    private fun assertEvaluationOnRolls(sequenceOfRolls: String, score: Int) {
        assertThat(bowlingGame.evaluateScore(sequenceOfRolls), `is`(score))
    }
}

