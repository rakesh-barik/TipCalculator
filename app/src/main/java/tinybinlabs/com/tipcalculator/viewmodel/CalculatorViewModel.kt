package tinybinlabs.com.tipcalculator.viewmodel

import tinybinlabs.com.tipcalculator.model.RestaurantCalculator
import tinybinlabs.com.tipcalculator.model.TipCalculation

class CalculatorViewModel(private val calculator: RestaurantCalculator = RestaurantCalculator()){

    var inputCheckAmount = ""

    var inputTipPercentage = ""

    var tipCalculation = TipCalculation()

    fun calculateTip(){
        val checkAmount = inputCheckAmount.toDoubleOrNull()
        val tipPct = inputTipPercentage.toIntOrNull()

        if(checkAmount != null && tipPct != null)
        tipCalculation = calculator.calculateTip(checkAmount,tipPct)
    }


}