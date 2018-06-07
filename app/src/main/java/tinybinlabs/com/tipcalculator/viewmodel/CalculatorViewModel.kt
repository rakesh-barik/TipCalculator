package tinybinlabs.com.tipcalculator.viewmodel

import android.app.Application
import android.databinding.BaseObservable
import android.util.Log
import tinybinlabs.com.tipcalculator.R
import tinybinlabs.com.tipcalculator.model.RestaurantCalculator
import tinybinlabs.com.tipcalculator.model.TipCalculation

class CalculatorViewModel(private val application: Application, private val calculator: RestaurantCalculator = RestaurantCalculator()) : BaseObservable(){

    var inputCheckAmount = ""

    var inputTipPercentage = ""

    var tipCalculation = TipCalculation()

    var outputCheckAmount = ""
    var outputTipAmount = ""
    var outputTotalAmount = ""

    init {
        updateOutputs(TipCalculation())
    }

    private fun updateOutputs(tc: TipCalculation) {
        outputCheckAmount =  application.getString(R.string.dollar_amount, tc.checkAmount)
        outputTipAmount = application.getString(R.string.dollar_amount, tc.tipAmount)
        outputTotalAmount = application.getString(R.string.dollar_amount, tc.grandTotal)
    }

    fun calculateTip(){

        Log.d(TAG, "calculateTipInvoked")

        val checkAmount = inputCheckAmount.toDoubleOrNull()
        val tipPct = inputTipPercentage.toIntOrNull()

        if(checkAmount != null && tipPct != null) {
            updateOutputs(calculator.calculateTip(checkAmount, tipPct))
            notifyChange()
        }
        clearInputs()
    }

    private fun clearInputs() {
        inputCheckAmount = "0.00"
        inputTipPercentage = "0"
    }


}

private const val TAG = "CalculatorViewModel"