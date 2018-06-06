package tinybinlabs.com.tipcalculator.model


import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class RestaurantCalculatorTest{

    private lateinit var calculator : RestaurantCalculator

    @Before
    fun setup(){
        calculator = RestaurantCalculator()
    }

    @Test
    fun testCalculatorTip(){

        val baseTc = TipCalculation(checkAmount = 10.00)

        var testVals =  listOf(baseTc.copy(tipPct = 25, tipAmount = 2.5, grandTotal = 12.5),
                baseTc.copy(tipPct = 10, tipAmount = 1.0, grandTotal = 11.0),
                baseTc.copy(tipPct = 18, tipAmount = 1.8, grandTotal = 11.8))

        testVals.forEach {
            assertEquals(it, calculator.calculateTip(it.checkAmount, it.tipPct))
        }
    }

}