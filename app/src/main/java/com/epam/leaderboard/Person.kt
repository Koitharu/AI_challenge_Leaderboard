package com.epam.leaderboard

data class Person(
    val name: String,
    val username: String,
    val avatarUrl: String,
    val score: Int,
    val trend: Trend
) {
    enum class Trend {
        UP,
        DOWN
    }
}
