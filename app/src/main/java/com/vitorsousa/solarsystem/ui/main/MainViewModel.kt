package com.vitorsousa.solarsystem.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vitorsousa.solarsystem.R
import com.vitorsousa.solarsystem.data.CelestialObject
import com.vitorsousa.solarsystem.data.CelestialType

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
                    size = 1.392F,
                    gravity = 274.0F,
                    image = R.mipmap.sun
                ), CelestialObject(
                    name = "Mercury",
                    type = CelestialType.PLANET,
                    size = 4.879F,
                    gravity = 3.7F,
                    image = R.mipmap.mercury
                ), CelestialObject(
                    name = "Sun",
                    type = CelestialType.STAR,
                    size = 45F,
                    gravity = 4F,
                    image = R.mipmap.sun
                ), CelestialObject(
                    name = "Sun",
                    type = CelestialType.STAR,
                    size = 45F,
                    gravity = 4F,
                    image = R.mipmap.sun
                ), CelestialObject(
                    name = "Sun",
                    type = CelestialType.STAR,
                    size = 45F,
                    gravity = 4F,
                    image = R.mipmap.sun
                ),
            )
        )
    }

}