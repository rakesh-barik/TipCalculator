package tinybinlabs.com.tipcalculator.model

import android.arch.lifecycle.LiveData
import android.util.Log
import java.math.RoundingMode

class RestaurantCalculator(val repository: TipCalculationRepository = TipCalculationRepository()) {
    fun calculateTip(checkInput: Double, tipPctInput: Int): TipCalculation {
        val tipAmount = (checkInput * (tipPctInput.toDouble() / 100.0))
                .toBigDecimal()
                .setScale(2,RoundingMode.HALF_UP)
                .toDouble()

        val grandTotal = checkInput + tipAmount
        Log.d("Total amount: ", grandTotal.toString())
        return TipCalculation(
                checkAmount = checkInput,
                tipPct =  tipPctInput,
                tipAmount = tipAmount,
                grandTotal = grandTotal
        )
    }

    fun saveTipCalculation(tipCalculation: TipCalculation){
        repository.saveTipCalculation(tipCalculation)
    }

    fun loadTipCalculationByName(locationName: String) : TipCalculation?{
        return repository.loadTipCalculationByName(locationName)
    }

    fun loadSavedTipCalculations(): LiveData<List<TipCalculation>>{
        return repository.loadSavedTipCalculations()
    }
}