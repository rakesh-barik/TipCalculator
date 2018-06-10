package tinybinlabs.com.tipcalculator.model

import android.util.Log
import java.math.RoundingMode

class RestaurantCalculator {
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
}