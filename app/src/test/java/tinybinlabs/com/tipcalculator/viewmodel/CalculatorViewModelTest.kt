package tinybinlabs.com.tipcalculator.viewmodel

import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import tinybinlabs.com.tipcalculator.model.RestaurantCalculator
import tinybinlabs.com.tipcalculator.model.TipCalculation

class CalculatorViewModelTest{
    lateinit var calculatorViewModel: CalculatorViewModel

    @Mock
    lateinit var mockCalculator: RestaurantCalculator

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        calculatorViewModel = CalculatorViewModel(mockCalculator)
    }

    @Test
    fun testCalculateTip(){
        calculatorViewModel.inputCheckAmount = "10.00"
        calculatorViewModel.inputTipPercentage = "15"

        val stub = TipCalculation(checkAmount = 10.00,tipPct = 15, tipAmount = 1.50,grandTotal = 11.50)
        `when` (mockCalculator.calculateTip(10.00,15)).thenReturn(stub)

        calculatorViewModel.calculateTip()

        assertEquals(stub, calculatorViewModel.tipCalculation)
    }

    @Test
    fun testCalculateTipBadTipPercent(){
        calculatorViewModel.inputCheckAmount = "10.00"
        calculatorViewModel.inputTipPercentage = ""

        calculatorViewModel.calculateTip()

        verify(mockCalculator, never()).calculateTip(ArgumentMatchers.anyDouble(), ArgumentMatchers.anyInt())
    }
}