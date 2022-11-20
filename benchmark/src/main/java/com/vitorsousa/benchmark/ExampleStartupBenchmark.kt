package com.vitorsousa.benchmark

import androidx.benchmark.macro.*
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * This is an example startup benchmark.
 *
 * It navigates to the device's home screen, and launches the default activity.
 *
 * Before running this benchmark:
 * 1) switch your app's active build variant in the Studio (affects Studio runs only)
 * 2) add `<profileable android:shell="true" />` to your app's manifest, within the `<application>` tag
 *
 * Run this benchmark from Studio to see startup measurements, and captured system traces
 * for investigating your app's performance.
 */
@RunWith(AndroidJUnit4::class)
class ExampleStartupBenchmark {
    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()


    @Test
    fun startUpCompilationModeNone() = startup(CompilationMode.None())

    @Test
    fun startUpCompilationModePartial() = startup(CompilationMode.Partial())


    @Test
    fun scrollCompilationModeNone() = scrollRecyclerView(CompilationMode.None())

    @Test
    fun scrollCompilationModePartial() = scrollRecyclerView(CompilationMode.Partial())


    fun startup(mode: CompilationMode) = benchmarkRule.measureRepeated(
        packageName = packageName,
        metrics = listOf(StartupTimingMetric()),
        iterations = 5,
        startupMode = StartupMode.COLD,
        compilationMode = mode
    ) {
        pressHome()
        startActivityAndWait()
    }

    fun scrollRecyclerView(mode: CompilationMode) = benchmarkRule.measureRepeated(
        packageName = packageName,
        metrics = listOf(FrameTimingMetric()),
        iterations = 5,
        startupMode = StartupMode.COLD,
        compilationMode = mode,
        setupBlock = {
            pressHome()
            startActivityAndWait()
        }
    ) {
        scrollRecyclerView()
    }


    fun MacrobenchmarkScope.scrollRecyclerView() {
        val recyclerView = device.findObject(By.res(packageName, "recyclerView_celestial"))
        recyclerView.setGestureMargin(device.displayWidth / 5)
        recyclerView.fling(Direction.DOWN)
        recyclerView.fling(Direction.UP)

        device.waitForIdle()
    }


    companion object {
        const val packageName = "com.vitorsousa.solarsystem"
    }
}