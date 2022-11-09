package com.vitorsousa.solarsystem.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vitorsousa.solarsystem.R
import com.vitorsousa.solarsystem.data.CelestialObject
import com.vitorsousa.solarsystem.data.CelestialType
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var solarSystem = MutableLiveData<List<CelestialObject>>()
        private set


    init {
        loadSolarSystem()
    }


    private fun loadSolarSystem() {
        solarSystem.postValue(
            listOf(
                CelestialObject(
                    name = "Sun",
                    type = CelestialType.STAR,
                    size = 1392700F,
                    gravity = 274.0F,
                    image = R.mipmap.sun
                ), CelestialObject(
                    name = "Mercury",
                    type = CelestialType.PLANET,
                    size = 	4879.4F,
                    gravity = 3.7F,
                    image = R.mipmap.mercury
                ), CelestialObject(
                    name = "Venus",
                    type = CelestialType.PLANET,
                    size = 12103.6F,
                    gravity = 8.87F,
                    image = R.mipmap.venus
                ), CelestialObject(
                    name = "Earth",
                    type = CelestialType.PLANET,
                    size = 12756.2F,
                    gravity = 9.78F,
                    image = R.mipmap.earth
                ), CelestialObject(
                    name = "Mars",
                    type = CelestialType.PLANET,
                    size = 6792.4F,
                    gravity = 3.72F,
                    image = R.mipmap.mars
                ), CelestialObject(
                    name = "Jupiter",
                    type = CelestialType.PLANET,
                    size = 142984F,
                    gravity = 24.79F,
                    image = R.mipmap.jupiter
                ), CelestialObject(
                    name = "Saturn",
                    type = CelestialType.PLANET,
                    size = 120536F,
                    gravity = 10.44F,
                    image = R.mipmap.saturn
                ), CelestialObject(
                    name = "Uranus",
                    type = CelestialType.PLANET,
                    size = 50724F,
                    gravity = 8.69F,
                    image = R.mipmap.uranus
                ), CelestialObject(
                    name = "Neptune",
                    type = CelestialType.PLANET,
                    size = 49528F,
                    gravity = 11.15F,
                    image = R.mipmap.neptune
                ),
            )
        )
    }

}