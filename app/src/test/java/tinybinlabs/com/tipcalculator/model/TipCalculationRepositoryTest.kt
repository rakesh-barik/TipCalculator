package tinybinlabs.com.tipcalculator.model

import android.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class TipCalculationRepositoryTest{

    @get:Rule
    var rule : TestRule = InstantTaskExecutorRule()

    lateinit var repository : TipCalculationRepository

    @Before
    fun setup(){
        repository = TipCalculationRepository()
    }

    // test to get same data as output when input data is given.
    @Test
    fun testSaveTip(){
        val tip1 = TipCalculation(locationName = "Biriyani Paradise",
                checkAmount = 100.0, tipPct = 25, tipAmount = 25.0, grandTotal = 125.0)


        val tip2 = TipCalculation(locationName = "Ramookaka",
                checkAmount = 100.0, tipPct = 25, tipAmount = 25.0, grandTotal = 125.0)

        repository.saveTipCalculation(tip1)
        repository.saveTipCalculation(tip2)

        //assertEquals(tip,repository.loadTipCalculationByName(tip.locationName))

        repository.loadSavedTipCalculations().observeForever{
            tipCalculations ->
            assertEquals(2, tipCalculations?.size)
        }
    }
}