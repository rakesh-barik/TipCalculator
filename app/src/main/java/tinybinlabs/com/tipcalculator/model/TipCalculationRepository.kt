package tinybinlabs.com.tipcalculator.model

class TipCalculationRepository {

    private val savedTips = mutableMapOf<String, TipCalculation>()

    fun saveTipCalculation(tc: TipCalculation){
        savedTips[tc.locationName] = tc
    }

    fun loadTipCalculationByName(locationName: String) : TipCalculation?{
        return savedTips[locationName]
    }
}
