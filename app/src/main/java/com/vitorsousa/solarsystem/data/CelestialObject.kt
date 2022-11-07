package com.vitorsousa.solarsystem.data

import androidx.annotation.DrawableRes

data class CelestialObject(
    val name: String,
    val type: CelestialType,
    val size: Float,
    val gravity: Float,
    @DrawableRes val image: Int
)

enum class CelestialType {
    STAR, PLANET
}