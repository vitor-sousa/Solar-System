package com.vitorsousa.benchmark

import androidx.benchmark.macro.ExperimentalBaselineProfilesApi
import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.benchmark.macro.junit4.BaselineProfileRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@OptIn(ExperimentalBaselineProfilesApi::class)
@RunWith(AndroidJUnit4::class)
class BaselineProfileGenerator {

    @get:Rule
    val baselineProfileRule = BaselineProfileRule()


    @Test
    fun generateBaselineProfile() = baselineProfileRule.collectBaselineProfile(
        packageName = ExampleStartupBenchmark.packageName,
    ) {
        pressHome()
        startActivityAndWait()

        scrollRecyclerView()
    }


    fun MacrobenchmarkScope.scrollRecyclerView() {
        val recyclerView = device.findObject(By.res(packageName, "recyclerView_celestial"))
        recyclerView.setGestureMargin(device.displayWidth / 5)
        recyclerView.fling(Direction.DOWN)
        recyclerView.fling(Direction.UP)

        device.waitForIdle()
    }

}