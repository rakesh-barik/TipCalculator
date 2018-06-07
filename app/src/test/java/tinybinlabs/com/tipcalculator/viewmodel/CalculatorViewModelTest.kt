package tinybinlabs.com.tipcalculator.viewmodel

import android.app.Application
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import tinybinlabs.com.tipcalculator.R
import tinybinlabs.com.tipcalculator.model.RestaurantCalculator
import tinybinlabs.com.tipcalculator.model.TipCalculation

class CalculatorViewModelTest{
    lateinit var calculatorViewModel: CalculatorViewModel

    @Mock
    lateinit var application: Application

    @Mock
    private
    lateinit var mockCalculator: RestaurantCalculator

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        stubResource(0.00,"$0.00")
        calculatorViewModel = CalculatorViewModel(application, mockCalculator)
    }

    private fun stubResource(given : Double, returnStub : String){
        `when` (application.getString(R.string.dollar_amount, given)).thenReturn(returnStub)
    }

    @Test
    fun testCalculateTip(){
        calculatorViewModel.inputCheckAmount = "10.00"
        calculatorViewModel.inputTipPercentage = "15"

        val stub = TipCalculation(checkAmount = 10.00,tipPct = 15, tipAmount = 1.50,grandTotal = 11.50)
        `when` (mockCalculator.calculateTip(10.00,15)).thenReturn(stub)

        stubResource(10.00,"$10.00")
        stubResource(1.50,"$1.50")
        stubResource(11.50,"$11.50")

        calculatorViewModel.calculateTip()

        //assertEquals(stub, calculatorViewModel.tipCalculation)

        assertEquals("$10.00", calculatorViewModel.outputCheckAmount)
        assertEquals("$1.50", calculatorViewModel.outputTipAmount)
        assertEquals("$11.50", calculatorViewModel.outputTotalAmount)
    }

    @Test
    fun testCalculateTipBadTipPercent(){
        calculatorViewModel.inputCheckAmount = "10.00"
        calculatorViewModel.inputTipPercentage = ""

        calculatorViewModel.calculateTip()

        verify(mockCalculator, never()).calculateTip(ArgumentMatchers.anyDouble(), ArgumentMatchers.anyInt())
    }
}