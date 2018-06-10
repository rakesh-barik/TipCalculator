package tinybinlabs.com.tipcalculator.model

import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TipCalculationRepositoryTest{

    lateinit var repository : TipCalculationRepository

    @Before
    fun setup(){
        repository = TipCalculationRepository()
    }

    // test to get same data as output when input data is given.
    @Test
    fun testSaveTip(){
        val tip = TipCalculation(locationName = "Biriyani Paradise",
                checkAmount = 100.0, tipPct = 25, tipAmount = 25.0, grandTotal = 125.0)
        repository.saveTipCalculation(tip)

        assertEquals(tip,repository.loadTipCalculationByName(tip.locationName))
    }
}